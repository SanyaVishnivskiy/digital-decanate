using Server.Business.Users.Models;
using Server.Business.Users.Repository;
using System;
using System.Threading.Tasks;

namespace Server.Business.Users.Component
{
    public class UserComponent : IUserComponent
    {
        private readonly IUserRepository _userRepository;

        public UserComponent(IUserRepository repository)
        {
            _userRepository = repository;
        }

        public Task Create(User user)
        {
            return _userRepository.Create(user);
        }

        public Task Delete(string id)
        {
            throw new NotImplementedException();
        }

        public Task<User> Get(string id)
        {
            return _userRepository.GetFullUser(id);
        }
    }
}
