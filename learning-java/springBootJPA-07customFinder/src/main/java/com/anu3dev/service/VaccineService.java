package com.anu3dev.service;

import java.util.Collection;
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
	public List<Vaccine> fetchByCost(Double cost){
		return repo.findByCost(cost);
	}

	@Override
	public List<Vaccine> fetchByCostLessThanEqual(Double cost){
		return repo.findByCostLessThanEqual(cost);
	}

	@Override
	public List<Vaccine> fetchByCostBetween(Double startCost, Double endingCost) {
		return repo.findByCostBetween(startCost, endingCost);
	}

	@Override
	public List<Vaccine> fetchByVaccineCompanyEquals(String name) {
		return repo.findByVaccineCompanyEquals(name);
	}

	@Override
	public List<Vaccine> fetchdByVaccineNameInAndCostBetween(Collection<String> names, Double minCost, Double maxCost) {
		return repo.findByVaccineNameInAndCostBetween(names, minCost, maxCost);
	}
}
