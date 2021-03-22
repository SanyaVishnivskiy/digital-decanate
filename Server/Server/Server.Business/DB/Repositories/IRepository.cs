using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace Server.Business.DB.Repositories
{
    public interface IRepository<T> where T : class
    {
        Task Create(T item);
        Task<T> Get(string id);
        Task<List<T>> Get();
        Task<List<T>> Get(Func<T, bool> predicate);
        Task Delete(string id);
        Task Update(T item);
    }
}
