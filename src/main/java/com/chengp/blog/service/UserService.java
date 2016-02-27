package com.chengp.blog.service;

import com.chengp.blog.entity.Blog;
import com.chengp.blog.entity.Item;
import com.chengp.blog.entity.Role;
import com.chengp.blog.entity.User;
import com.chengp.blog.repository.BlogRepository;
import com.chengp.blog.repository.ItemRepository;
import com.chengp.blog.repository.RoleRepository;
import com.chengp.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 2/24/16.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<User> findAll() {

        return userRepository.findAll();
    }

    public  User findOne(Integer id) {

        return userRepository.findOne(id);
    }

    @Transactional
    public User findOneWithBlogs(Integer id) {
        User user = userRepository.findOne(id);
        List<Blog> blogs = blogRepository.findByUser(user);
        for (Blog blog:blogs) {
            List<Item> items = itemRepository.findByBlog(blog,
                    new PageRequest(0,10, Sort.Direction.ASC,"publishedDate"));
            blog.setItems(items);
        }
        user.setBlogs(blogs);
        return user;
    }

    public void save(User user) {
        user.setEnabled(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        List<Role> roles = new ArrayList<Role>();
        roles.add(roleRepository.findByName("ROLE_USER"));
        user.setRoles(roles);

        userRepository.save(user);
    }

    public User findOneWithBlogs(String name) {

        User user = userRepository.findByName(name);

        return findOneWithBlogs(user.getId());
    }
}
