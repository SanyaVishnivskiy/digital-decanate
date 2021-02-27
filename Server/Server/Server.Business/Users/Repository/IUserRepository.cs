using Server.Business.DB.Repositories;
using Server.Business.Users.Models;
using System.Threading.Tasks;

namespace Server.Business.Users.Repository
{
    public interface IUserRepository : IRepository<User>
    {
        Task<User> GetFullUser(string id);
    }
}
