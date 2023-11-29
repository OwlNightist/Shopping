package com.example.shopping.repository;

import com.example.shopping.entity.User.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByName(String user);
}
