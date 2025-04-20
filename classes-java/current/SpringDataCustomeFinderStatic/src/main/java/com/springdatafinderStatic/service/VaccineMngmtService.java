package com.springdatafinderStatic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatafinderStatic.entity.VaccineRepo;
import com.springdatafinderStatic.type.ResultView;



@Service("vservice")
public class VaccineMngmtService implements IVaccineMngmt {

	@Autowired
	private VaccineRepo repo;

	@Override
	public List<ResultView> searchVaccineByStartPrice(Integer price) 
	{
		
		return repo.findByPriceGreaterThanEqual(price);
		
	}

	

}
