package com.chengp.blog.repository;

import com.chengp.blog.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pc on 2/24/16.
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {

    Role findByName(String name);
}
