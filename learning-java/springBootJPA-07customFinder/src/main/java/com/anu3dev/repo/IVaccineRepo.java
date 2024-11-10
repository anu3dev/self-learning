package com.anu3dev.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu3dev.entity.Vaccine;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer> {	
	public List<Vaccine> findByCost(Double cost);
	public List<Vaccine> findByCostLessThanEqual(Double cost);
	public List<Vaccine> findByCostBetween(Double startCost, Double endingCost);
	public List<Vaccine> findByVaccineCompanyEquals(String name);
	public List<Vaccine> findByVaccineNameInAndCostBetween(Collection<String> names,Double minCost, Double maxCost);
}
