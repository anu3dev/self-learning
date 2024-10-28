package com.sb.JpaRepo.service;

import java.util.List;

import com.sb.JpaRepo.entity.VaccineDetails;

public interface IVaccineManagement {
	// JpaRepository
    public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccine, boolean status, String... args);
    public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccine);
    public VaccineDetails searchVaccineById(Long id);
    public String removeVaccineByIdsFromJpa(Iterable<Long> ids);
}
