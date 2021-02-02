package com.example.study.repository;

import com.example.study.StudyApplication;
import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser2");

        User newUser = userRepository.save(user);
        System.out.println("newUser: " + newUser);
    }

    @Test
    public void read() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            System.out.println("user: " + selectUser);
            System.out.println("email: " + selectUser.getEmail());
        });
    }
    @Test
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    public void delete() {
        Optional<User> user = userRepository.findById(1L);

        Assertions.assertTrue(user.isPresent())

        user.ifPresent(selectUser ->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);

        Assertions.assertFalse(deleteUser.isPresent());
        }
    }
}
