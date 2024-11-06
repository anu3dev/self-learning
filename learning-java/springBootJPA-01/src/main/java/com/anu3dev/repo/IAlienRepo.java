package com.anu3dev.repo;

import org.springframework.data.repository.CrudRepository;

import com.anu3dev.entity.Alien;

public interface IAlienRepo extends CrudRepository<Alien, Integer>{}
	