package com.anu3dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu3dev.dao.ITouristRepo;
import com.anu3dev.exception.TouristNotFoundException;
import com.anu3dev.model.Tourist;

@Service
public class TouristManagement implements ITouristManagement {
	@Autowired
	private ITouristRepo repo;

	@Override
	public String registerTourist(Tourist tourist) {
		Tourist touristObj = repo.save(tourist);
		return "data added with id " + touristObj.getId();
	}

	@Override
	public List<Tourist> fetchAllTourists() {
		return repo.findAll();
	}

	@Override
	public Tourist fetchTourist(Integer id) {
		return repo.findById(id).orElseThrow(()-> new 
				TouristNotFoundException("Tourist with id "+id+ " not found"));
	}

	@Override
	public String updateTouristByDetails(Tourist tourist) {
		Integer id = tourist.getId();
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()){
			repo.save(tourist);
			return "Tourist with id "+ tourist.getId()+ " updated";
		}
		else {
			throw new TouristNotFoundException("Tourist with id "+ tourist.getId()+ " not available for updating");
		}
	}
	
	@Override
	public String updateTouristById(Integer id, Double budgetHike) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()){
			Tourist tourist = optional.get();
			tourist.setBudget(budgetHike);
			repo.save(tourist);
			return "Tourist with id "+ tourist.getId()+ " is updated";
		}
		else {
			throw new TouristNotFoundException("Tourist with id "+ id+ " not available for updating");
		}
	}
	
	@Override
	public String deleteTouristById(Integer id) {
		Optional<Tourist> optional = repo.findById(id);
		if(optional.isPresent()){
			repo.deleteById(id);
			return "Tourist with id "+ id+ " is Deleted";
		}
		else {
			throw new TouristNotFoundException("Tourist with id "+ id+ " not available for Deletion");
		}
	}
}
