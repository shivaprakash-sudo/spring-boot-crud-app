package com.crudapi.SimpleCRUDApp;

import com.crudapi.SimpleCRUDApp.user.User;
import com.crudapi.SimpleCRUDApp.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;

    @Test
    public void testAddNewUser() {
        User user = new User();
        user.setEmail("shiva@gmail.com");
        user.setPassword("shiva@143");
        user.setFirstName("Shiva Prakash");
        user.setLastName("Pendem");
        User savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers() {
        Iterable<User> allUsers = repo.findAll();

        Assertions.assertThat(allUsers).hasSizeGreaterThan(0);
        for (User user: allUsers) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdateUser() {
        Integer id = 1;
        Optional<User> optionalUser = repo.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword("12342435dvsvfg");
            repo.save(user);
        }
        Optional<User> optionalUpdatedUser = repo.findById(id);
        if (optionalUpdatedUser.isPresent()) {
            User user = optionalUpdatedUser.get();
            Assertions.assertThat(user.getPassword()).isEqualTo("12342435dvsvfg");
        }
    }

    @Test
    public void testGetUserById() {
        Integer id = 2;
        Optional<User> optionalUser = repo.findById(id);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDeleteUser() {
        Integer id = 2;
        repo.deleteById(id);
        Optional<User> optionalUser = repo.findById(id);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
}
