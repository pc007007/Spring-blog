package com.chengp.blog.repository;

import com.chengp.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pc on 2/24/16.
 */
public interface BlogRepository extends JpaRepository<Blog,Integer> {


}
