package com.example.study.repository;

import com.example.study.StudyApplication;
import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    public void create() {
        User user = new User();
        user.setAccount();
        user.setEmail();
        user.setPhoneNumber();
        user.setCreatedAt();
        user.setCreatedBy();
    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }
}