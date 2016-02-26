package com.chengp.blog.repository;

import com.chengp.blog.entity.Blog;
import com.chengp.blog.entity.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc on 2/24/16.
 */
public interface ItemRepository extends JpaRepository<Item,Integer> {

    List<Item> findByBlog(Blog blog, Pageable pageable);
}
