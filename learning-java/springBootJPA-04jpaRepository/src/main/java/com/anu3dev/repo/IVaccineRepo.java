package com.anu3dev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu3dev.entity.Vaccine;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer>{}
