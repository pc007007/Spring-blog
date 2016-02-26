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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pc on 2/24/16.
 */
@Transactional
@Service
public class InitDbService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BlogRepository blogRepository;

    @PostConstruct
    public void init() {

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleRepository.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleRepository.save(roleAdmin);

        User userAdmin = new User();
        userAdmin.setEnabled(true);
        userAdmin.setName("admin");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userAdmin.setPassword(encoder.encode("admin"));
        List<Role> roles = new ArrayList<Role> ();
        roles.add(roleUser);
        roles.add(roleAdmin);
        userAdmin.setRoles(roles);
        userRepository.save(userAdmin);

        Blog blogCheng = new Blog();
        blogCheng.setName("Cheng");
        blogCheng.setUrl("http://feeds.feedburner.com/javavids?format=xml");
        blogCheng.setUser(userAdmin);
        blogRepository.save(blogCheng);

        Item item1 = new Item();
        item1.setBlog(blogCheng);
        item1.setTitle("first");
        item1.setLink("http://www.google.com");
        item1.setPublishedDate(new Date());
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setBlog(blogCheng);
        item2.setTitle("second");
        item2.setLink("http://www.google.com");
        item2.setPublishedDate(new Date());
        itemRepository.save(item2);
    }
}
