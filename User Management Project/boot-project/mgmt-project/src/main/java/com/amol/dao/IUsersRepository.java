package com.amol.dao;

        import com.amol.entities.Users;
        import org.springframework.data.repository.CrudRepository;

public interface IUsersRepository extends CrudRepository<Users, Integer> {
    int countById(int id);
}
