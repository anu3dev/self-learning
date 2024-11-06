package com.anu3dev.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.anu3dev.entity.Vaccine;

public interface IVaccineRepo extends PagingAndSortingRepository<Vaccine,Integer>{}
