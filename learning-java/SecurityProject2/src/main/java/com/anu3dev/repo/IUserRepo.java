package com.anu3dev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu3dev.entity.Users;

public interface IUserRepo extends JpaRepository<Users, String> {
	Users findByName(String userName);
}
