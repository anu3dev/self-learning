package com.anu3dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	public Vaccine searchVaccineById(Integer id) {
		return repo.getReferenceById(id);
	}


	@Override
	public List<Vaccine> searchVaccineByGivenInfo(Vaccine vac) {
		Example<Vaccine> example =Example.of(vac);
		return repo.findAll(example);	
	}

	@Override
	public String removeVaccineInfoByIds(Iterable<Integer> ids) {
        List<Vaccine> list = repo.findAllById(ids);
        if(list.size() != 0){
        	repo.deleteAllByIdInBatch(ids);
        	return "Records deleted for given ids";
        }
		return "Unable to delete records";
	}
}
