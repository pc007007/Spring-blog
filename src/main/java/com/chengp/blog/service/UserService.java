package com.chengp.blog.service;

import com.chengp.blog.entity.User;
import com.chengp.blog.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pc on 2/24/16.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    public List<User> findAll() {

        return userRepository.findAll();
    }
}
