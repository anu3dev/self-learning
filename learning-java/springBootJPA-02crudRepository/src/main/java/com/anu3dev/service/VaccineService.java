package com.anu3dev.service;

import java.util.List;
import java.util.Optional;

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
	public String registerVaccineInfo(Vaccine vaccine) {
		Vaccine vac=repo.save(vaccine);
		return "Vaccine Info registered with id "+ vac.getId();
	}

	@Override
	public Iterable<Vaccine> registerMultipleVaccineInfo(Iterable<Vaccine> vaccines) {	
		return repo.saveAll(vaccines);
	}

	@Override
	public Long vaccinesCount() {
		return repo.count();
	}

	@Override
	public Boolean checkVaccineAvailability(Integer id) {
		return repo.existsById(id);
	}

	@Override
	public Iterable<Vaccine> getAllVaccinesInfo() {
		return repo.findAll();
	}

	@Override
	public Iterable<Vaccine> getAllVaccines(Iterable<Integer> ids) {
		return repo.findAllById(ids);
	}

	@Override
	public Optional<Vaccine> getVaccineById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public String removeVaccineById(Integer id) {
		Boolean status = repo.existsById(id);
		if(status){
			repo.deleteById(id);
			return "Record with id "+id+" is deleted";
		}
		return "Record with id "+id+" is not available to delete";
	}

	@Override
	public String removeVaccineByVaccine(Vaccine obj) {
		Integer id = obj.getId();
		Optional<Vaccine> optional = repo.findById(id);
		if(optional.isPresent()){
			repo.deleteById(id);
			return "Record with id "+id+" is deleted";
		}
		return "Record with id "+id+" is not available to delete";
	}

	@Override
	public String removeAllVaccines(List<Integer> ids) {
		List<Vaccine> vaccines = (List<Vaccine>) repo.findAllById(ids);
		int count2 = vaccines.size();
		if(count2>0){
	    	repo.deleteAllById(ids);
	    	return "Vaccine Info deleted for given ids";
	    }
		return "Failed to deleted vaccine info";
	}
}
