using Server.Business.Users.Models;
using System.Threading.Tasks;

namespace Server.Business.Users.Component
{
    public interface IUserComponent
    {
        Task<User> Get(string id);
        Task Create(User user);
        Task Delete(string id);
    }
}
