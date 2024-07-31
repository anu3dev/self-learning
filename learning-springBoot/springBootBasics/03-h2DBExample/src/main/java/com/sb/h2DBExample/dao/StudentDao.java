package com.sb.h2DBExample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.h2DBExample.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {}
