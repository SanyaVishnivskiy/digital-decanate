using System.ComponentModel.DataAnnotations;

namespace Server.Business.Users.Models
{
    public class User
    {
        [Required]
        [MaxLength(50)]
        public string Id { get; set; }

        [MaxLength(50)]
        public string Name { get; set; }

        [MaxLength(50)]
        public string Surname { get; set; }

        [Required]
        [MaxLength(90)]
        public string Password { get; set; }

        public Role Role { get; set; }
    }
}
