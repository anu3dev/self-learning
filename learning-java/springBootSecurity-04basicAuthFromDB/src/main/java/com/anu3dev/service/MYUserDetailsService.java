package com.anu3dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.anu3dev.entity.Users;
import com.anu3dev.repo.IUserRepo;

@Service
public class MYUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users users = repo.findByName(userName);
		if(users == null) {
			throw new UsernameNotFoundException("user not found 404");
		}
		return new MYUserDetails(users);
	}
}
