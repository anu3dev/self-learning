package com.anu3dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anu3dev.model.Users;

@Repository
public interface UsersDAO extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}