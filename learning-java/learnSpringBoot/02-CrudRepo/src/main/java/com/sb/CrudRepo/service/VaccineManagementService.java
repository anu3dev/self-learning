package com.sb.CrudRepo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.CrudRepo.entity.VaccineDetails;
import com.sb.CrudRepo.entity.VaccineRepoCrud;

@Service("vservice")
public class VaccineManagementService implements IVaccineManagement {
	@Autowired
	private VaccineRepoCrud crudRepo;
	
	@Override
	public String registerVaccine(VaccineDetails vaccine) {
		System.out.println("Proxy class details "+ crudRepo.getClass().getName());
		if(vaccine != null)
			crudRepo.save(vaccine);			
		return "Vaccine details have been inserted with vaccine id " + vaccine.getId();
	}
	  
	@Override
	public Iterable<VaccineDetails> registerInBatch(Iterable<VaccineDetails> vaccines) {
		return crudRepo.saveAll(vaccines);
	}

	@Override
	public Long getVaccinesCount() {
		return crudRepo.count();
	}

	@Override
	public Boolean checkAvailablity(Long id) {
		return crudRepo.existsById(id);
	}
	
	@Override
	public Iterable<VaccineDetails> fetchAllDetails() {
		return crudRepo.findAll();
	}
	
	@Override
	public Iterable<VaccineDetails> fetchAllDetailsById(List<Long> ids) {
	    return crudRepo.findAllById(ids);
	}
	
	@Override
	public Optional<VaccineDetails> fetchById(Long id) {
		return crudRepo.findById(id);
	}
	
	@Override
	public String removeVaccineById(Long id) {
		Optional<VaccineDetails> val = crudRepo.findById(id);
		if(val.isPresent()) {
			crudRepo.deleteById(id);
			return "id " + id + " deleted successfully";
		} else
			return "There is no record with id " + id;			
	}
	
	@Override
	public String removeVaccineByIdsFromCrud(List<Long> ids) {
		Iterable<VaccineDetails> list = crudRepo.findAllById(ids);
		
		int count = ids.size();
		
		if(count == ((List<VaccineDetails>) list).size()) {
			crudRepo.deleteAllById(ids);
		    return "No of records deleted are "+ count;
		} else
			return "Not all records present for given ids";
	}
	
	@Override
	public String removeVaccineByObject(VaccineDetails obj) {
		Optional<VaccineDetails> optional = crudRepo.findById(obj.getId());
		
		if(optional.isPresent()) {
			crudRepo.deleteById(obj.getId());
			return "id " + obj.getId() + " deleted successfully";
		}
		else
			return "There is no record with that id " + obj.getId();
	}
}
