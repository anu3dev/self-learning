package com.anu3dev.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu3dev.entity.Vaccine;
import com.anu3dev.repo.IVaccineRepo;

@Service
public class VaccineService implements IVaccineService {
	private IVaccineRepo repo;
	
	@Autowired
	public void setRepo(IVaccineRepo repo){	
		this.repo = repo;
	}

	@Override
	public List<Vaccine> fetchByVaccineCompany(String companyName) {
		return repo.searchByVaccineCompany(companyName);
	}

	@Override
	public List<Vaccine> fetchByVaccineCompany(String comp1, String comp2) {
		return repo.searchByVaccineCompany(comp1, comp2);
	}

	@Override
	public List<String> fetchVaccinesByCost(Double startingRange, Double maxRange) {
		return repo.searchVaccinesByCost(startingRange, maxRange);
	}

	@Override
	public int updateThePriceByVaccineName(Double newPrice, String vaccineName) {
		return repo.updatePriceByVaccineName(newPrice, vaccineName);
	}

	@Override
	public int deleteTheVaccinesByvaccineNames(String vaccineName) {
		return repo.deleteVaccinesByvaccineNames(vaccineName);
	}

	@Override
	public int insertVaccineDetails(Integer id,String vaccineName, String vaccineCompany, Double cost) {
		return repo.insertVaccineInfo(id,vaccineName, vaccineCompany, cost);
	}

	@Override
	public Date getSystemDateAndTime() {
		return repo.getTheSystemDateAndTime();
	}	
}
