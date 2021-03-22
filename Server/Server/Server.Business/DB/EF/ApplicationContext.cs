using Microsoft.EntityFrameworkCore;
using Server.Business.Users.Models;

namespace Server.Business.DB.EF
{
    public class ApplicationContext : DbContext
    {
        public DbSet<Role> Roles { get; set; }
        public DbSet<User> Users { get; set; }

        public ApplicationContext(DbContextOptions options) : base(options)
        {
            Database.EnsureCreated();
        }
    }
}
