using System;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Server.Business.Users.Component;
using Server.Business.Users.Models;

namespace Server.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly IUserComponent _component;

        public UserController(IUserComponent component)
        {
            _component = component;
        }

        [HttpGet]
        [Route("{id}")]
        public async Task<IActionResult> GetUserById(string id)
        {
            var user = await _component.Get(id);
            if (user == null)
            {
                return NotFound();
            }

            return Ok(user);
        }

        [HttpGet]
        [Route("init")]
        public async Task<IActionResult> Init()
        {
            var user = new User
            {
                Id = "1",
                Name = "Admin",
                Password = "123456",
                Role = new Role { Id = Guid.NewGuid().ToString(), Name = "Admin"}
            };

            await _component.Create(user);
            return Ok(user);
        }
    }
}
