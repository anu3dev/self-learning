package com.sb.CrudRepo.service;

import java.util.List;
import java.util.Optional;

import com.sb.CrudRepo.entity.VaccineDetails;

public interface IVaccineManagement {
	// CrudRepository
	public String registerVaccine(VaccineDetails vaccine);
	public Iterable<VaccineDetails> registerInBatch(Iterable<VaccineDetails>vaccines);
	public Long getVaccinesCount();
	public Boolean checkAvailablity(Long id);
	public Iterable<VaccineDetails> fetchAllDetails();
	public Iterable<VaccineDetails> fetchAllDetailsById(List<Long>ids);    
	public Optional<VaccineDetails>fetchById(Long id);
	public String removeVaccineById(Long id);
	public String removeVaccineByIdsFromCrud(List<Long >ids);
	public String removeVaccineByObject(VaccineDetails obj);
}
