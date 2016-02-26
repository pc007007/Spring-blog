package com.chengp.blog.repository;

import com.chengp.blog.entity.Blog;
import com.chengp.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by pc on 2/24/16.
 */
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    List<Blog> findByUser(User user);
}
