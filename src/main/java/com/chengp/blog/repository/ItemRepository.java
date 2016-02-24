package com.chengp.blog.repository;

import com.chengp.blog.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pc on 2/24/16.
 */
public interface ItemRepository extends JpaRepository<Item,Integer> {


}
