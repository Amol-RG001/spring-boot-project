package com.amol.entities;

        import com.amol.dao.IUsersRepository;
        import java.util.List;
        import java.util.Optional;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUsersRepository iUsersRepo;

    public UserService() {
    }

    List<Users> usersList() {
        return (List)this.iUsersRepo.findAll();
    }

    public void save(Users user) {
        this.iUsersRepo.save(user);
    }

    public Users getById(int id) throws UserNotFoundException {
        Optional<Users> res = this.iUsersRepo.findById(id);
        if (res.isPresent()) {
            return (Users)res.get();
        } else {
            throw new UserNotFoundException("Could not find user id. " + id);
        }
    }

    public void deleteById(int id) throws UserNotFoundException {
        int count = this.iUsersRepo.countById(id);
        if (count >= 0 && count != 0) {
            this.iUsersRepo.deleteById(id);
        } else {
            throw new UserNotFoundException("Could not find user id. " + id);
        }
    }
}
