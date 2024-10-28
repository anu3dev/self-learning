package com.anu3dev.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu3dev.model.Email;

public interface EmailDAO extends JpaRepository<Email, Long> {}
