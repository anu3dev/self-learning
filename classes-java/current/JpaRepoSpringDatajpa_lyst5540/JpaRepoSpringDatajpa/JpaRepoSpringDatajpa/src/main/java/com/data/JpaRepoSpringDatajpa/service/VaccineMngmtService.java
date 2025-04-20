package com.data.JpaRepoSpringDatajpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.data.JpaRepoSpringDatajpa.entity.VaccineDetails;
import com.data.JpaRepoSpringDatajpa.entity.VaccineRepo;

@Service("vservice")
public class VaccineMngmtService implements IVaccineMngmt {

	@Autowired
	private VaccineRepo repo;

	
	

	@Override
	public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccine, boolean status, String... args) {
	
		System.out.println("The proxy class implementation is : "+ repo.getClass().getName());
		Example<VaccineDetails> example = Example.of(vaccine);
		Sort sort=Sort.by(status?Direction.ASC:Direction.DESC, args);
		
	
		
		return repo.findAll(example, sort);
		
	}




	@Override
	public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccine) {
		
		Example<VaccineDetails> example = Example.of(vaccine);
		return repo.findAll(example);
	
	}

	@SuppressWarnings("depcrecation")
	@Override
	public VaccineDetails searchVaccineById(Long id) 
	{
		//VaccineDetails vaccine = repo.getById(id);
		VaccineDetails vaccine =repo.getReferenceById(id);
		
		return vaccine;
	}




	@Override
	public String removeVaccineByIds(Iterable<Long> ids) {
		
		List<VaccineDetails> vaccineCol = repo.findAllById(ids);
		if(vaccineCol.size()!=0)
		{
		repo.deleteAllByIdInBatch(ids);
		return "deleted";
		}
		else
		{
			return "Couldnot delete bcz ids are wrong";
		}
		
	}
	




}
