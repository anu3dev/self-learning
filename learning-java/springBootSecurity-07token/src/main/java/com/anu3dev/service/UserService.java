package com.anu3dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu3dev.entity.Users;
import com.anu3dev.repo.IUserRepo;

@Service
public class UserService {
	@Autowired
	private IUserRepo repo;
	
	public Users register(Users user){
		return repo.save(user);
	}
}
