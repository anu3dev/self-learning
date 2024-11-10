package com.anu3dev.service;

import java.util.Collection;
import java.util.List;

import com.anu3dev.entity.Vaccine;

public interface IVaccineService {
	public List<Vaccine> fetchByCost(Double cost);
	public List<Vaccine> fetchByCostLessThanEqual(Double cost);
	public List<Vaccine> fetchByCostBetween(Double startCost, Double endingCost);
	public List<Vaccine> fetchByVaccineCompanyEquals(String name);
	public List<Vaccine> fetchdByVaccineNameInAndCostBetween(Collection<String> names,Double minCost, Double maxCost);
}
