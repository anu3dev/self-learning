package com.SpringdatacustomQuery.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringdatacustomQuery.entity.VaccineDetails;
import com.SpringdatacustomQuery.entity.VaccineRepo;




@Service("vservice")
public class VaccineMngmtService implements IVaccineMngmt {

	@Autowired
	private VaccineRepo repo;

	@Override
	public List<VaccineDetails> fetchVaccinesByCompanyName(String companyName) {
	return repo.searchVaccinesByCompanyName(companyName);
		
	}

	@Override
	public List<VaccineDetails> fetchVaccinesByCompanies(String comp1, String comp2) {
		
		return repo.searchVaccinesByCompanies(comp1, comp2);
	}

	@Override
	public List<String> fetachVaccinesByPriceRange(Integer min, Integer max) {
		
		return repo.searchVaccinesByPriceRange(min, max);
	}

	@Override
	public List<Object[]> fetchVaccinesByVaccinName(String vac1, String vac2) {
		
		return repo.searchVaccinesByVaccinName(vac1, vac2);
	}
//	@Override
//	public List<Object> fetchVaccinesByVaccinName(String vac1, String vac2) {
//		
//		return repo.searchVaccinesByVaccinName(vac1, vac2);
//	}

	@Override
	public int updateThePriceByVaccines(Integer newPrice, String vaccineName) {
		
		return repo.updatePriceByVaccines(newPrice, vaccineName);
	}

	@Override
	public int deleteTheVaccineByPrice(Integer minPrice, Integer maxPrice) {
		
		return repo.deleteVaccineByPrice(minPrice, maxPrice);
	}

	@Override
	public int insertVaccineDetails(Long id, String companyName, String vaccineName, Integer price) {
		
		return repo.insertVaccineData(id, companyName, vaccineName, price);
	}

	@Override
	public Date getTheSystemDateAndTime() {
		
		return repo.getTheSystemDateAndTime();
	}
	




	

}
