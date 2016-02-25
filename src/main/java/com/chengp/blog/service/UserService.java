package com.chengp.blog.service;

import com.chengp.blog.entity.User;
import com.chengp.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pc on 2/24/16.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public  User findOne(Integer id) {

        return userRepository.findOne(id);
    }
}
