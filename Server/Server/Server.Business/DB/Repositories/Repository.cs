using Microsoft.EntityFrameworkCore;
using Server.Business.DB.EF;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Server.Business.DB.Repositories
{
    public class Repository<T> : IRepository<T> where T: class
    {
        protected ApplicationContext Context { get; }
        protected DbSet<T> DBSet { get; }

        public Repository(ApplicationContext context)
        {
            Context = context;
            DBSet = context.Set<T>();
        }

        public Task<List<T>> Get()
        {
            return DBSet.AsNoTracking().ToListAsync();
        }

        public Task<List<T>> Get(Func<T, bool> predicate)
        {
            return DBSet
                .AsNoTracking()
                .Where(predicate)
                .AsQueryable()
                .ToListAsync();
        }
        public Task<T> Get(string id)
        {
            return DBSet.FindAsync(id).AsTask();
        }

        public Task Create(T item)
        {
            DBSet.Add(item);
            return Context.SaveChangesAsync();
        }

        public Task Update(T item)
        {
            Context.Entry(item).State = EntityState.Modified;
            return Context.SaveChangesAsync();
        }

        public async Task Delete(string id)
        {
            var item = await Get(id);
            DBSet.Remove(item);
            await Context.SaveChangesAsync();
        }
    }
}
