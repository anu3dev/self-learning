package com.springdatafinderDymanic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatafinderDymanic.entity.VaccineRepo;
import com.springdatafinderDymanic.type.View;





@Service("vservice")
public class VaccineMngmtService implements IVaccineMngmt {

	@Autowired
	private VaccineRepo repo;

	@Override
	public <T extends View> List<T> searchByVaccineCompany(String companyName, Class<T> cls) {
		
		 return repo.findByVaccineCompany(companyName, cls);

	}



	

}
