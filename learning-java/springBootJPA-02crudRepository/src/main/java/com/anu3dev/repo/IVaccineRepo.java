package com.anu3dev.repo;

import org.springframework.data.repository.CrudRepository;

import com.anu3dev.entity.Vaccine;

public interface IVaccineRepo extends CrudRepository<Vaccine, Integer> {}
