package com.sb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {}
