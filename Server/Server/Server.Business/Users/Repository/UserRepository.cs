using Microsoft.EntityFrameworkCore;
using Server.Business.DB.EF;
using Server.Business.DB.Repositories;
using Server.Business.Users.Models;
using System.Threading.Tasks;

namespace Server.Business.Users.Repository
{
    public class UserRepository : Repository<User>, IUserRepository
    {
        public UserRepository(ApplicationContext context) : base(context)
        {
        }

        public Task<User> GetFullUser(string id)
        {
            return Context.Users
                .Include(x => x.Role)
                .SingleOrDefaultAsync(x => x.Id == id);
        }
    }
}
