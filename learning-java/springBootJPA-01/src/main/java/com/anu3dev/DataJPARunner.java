package com.anu3dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.anu3dev.entity.Alien;
import com.anu3dev.repo.IAlienRepo;
@Component
public class DataJPARunner implements CommandLineRunner
{
	@Autowired
	private IAlienRepo repo;

	@Override
	public void run(String... args) throws Exception {
		repo.save(new Alien(2,"Rohit", "Mumbai"));
	}
}
