package com.anu3dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu3dev.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {}
