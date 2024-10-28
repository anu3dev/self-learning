package com.sb.JpaRepo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sb.JpaRepo.entity.VaccineDetails;
import com.sb.JpaRepo.entity.VaccineRepoJpa;

@Service("vservice")
public class VaccineManagementService implements IVaccineManagement {
	@Autowired
	private VaccineRepoJpa jpaRepo;
	
	@Override
	public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccine, boolean status, String... args) {
		Example<VaccineDetails> example = Example.of(vaccine);
		Sort sort=Sort.by(status?Direction.ASC:Direction.DESC, args);
		return jpaRepo.findAll(example, sort);
	}

	@Override
	public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccine) {
		Example<VaccineDetails> example = Example.of(vaccine);
		return jpaRepo.findAll(example);
	}

	@Override
	public VaccineDetails searchVaccineById(Long id){
		VaccineDetails vaccine =jpaRepo.getReferenceById(id);	
		return vaccine;
	}

	@Override
	public String removeVaccineByIdsFromJpa(Iterable<Long> ids){
		List<VaccineDetails> vaccineCol = jpaRepo.findAllById(ids);
		if(vaccineCol.size() != 0){
			jpaRepo.deleteAllByIdInBatch(ids);
			return "deleted";
		} else {
			return "Couldnot delete bcz ids are wrong";
		}	
	}
}
