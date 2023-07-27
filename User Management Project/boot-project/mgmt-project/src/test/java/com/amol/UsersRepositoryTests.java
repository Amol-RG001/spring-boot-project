package com.amol;

        import com.amol.dao.IUsersRepository;
        import com.amol.entities.Users;
        import java.util.Optional;
        import org.assertj.core.api.AssertionsForClassTypes;
        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
        import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(
        replace = Replace.NONE
)
@Rollback(false)
public class UsersRepositoryTests {
    @Autowired
    private IUsersRepository iUsersRepo;

    public UsersRepositoryTests() {
    }

    @Test
    public void testAddNewUser() {
        Users user = new Users();
        user.setFirstName("Ramesh");
        user.setLastName("kale");
        user.setEmail("example2@demo.com");
        user.setPassword("mpassKey");
        user.setActive(true);
        user.setStatus("Graduate");
        Users saveUser = (Users)this.iUsersRepo.save(user);
        AssertionsForClassTypes.assertThat(saveUser).isNotNull();
        AssertionsForClassTypes.assertThat(saveUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListOfUsers() {
        Iterable<Users> iterable = this.iUsersRepo.findAll();
        iterable.forEach((users) -> {
            System.out.println(iterable);
        });
    }

    @Test
    public void testGetUser() {
        int userId = 1;
        Optional<Users> usersOptional = this.iUsersRepo.findById(Integer.valueOf(userId));
        AssertionsForClassTypes.assertThat(usersOptional).isPresent();
        System.out.println(usersOptional.get());
    }

    @Test
    public void testUpdateUser() {
        int userId = 1;
        Optional<Users> optional = this.iUsersRepo.findById(Integer.valueOf(userId));
        Users user = (Users)optional.get();
        user.setPassword("MyPassKEY");
        this.iUsersRepo.save(user);
        Users updatedUser = (Users)this.iUsersRepo.findById(Integer.valueOf(userId)).get();
        System.out.println("NEW PASS KEY: " + updatedUser.getPassword());
    }

    @Test
    public void testDeleteUser() {
        int userId = 4;
        this.iUsersRepo.deleteById(Integer.valueOf(userId));
        Optional<Users> obj = this.iUsersRepo.findById(Integer.valueOf(userId));
        AssertionsForClassTypes.assertThat(obj).isNotPresent();
        System.out.println("DELETED..!");
    }
}
