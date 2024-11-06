package com.anu3dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	public Iterable<Vaccine> fetchDetailsBySorting(boolean status, String... properties){
		Sort sort = Sort.by(status?Direction.ASC:Direction.DESC, properties);
		return repo.findAll(sort);
	}

	@Override
	public List<Vaccine> fetchDetailsByPagination(int pgNo, int pgSize, boolean status, String... properties) {
		PageRequest pageable = PageRequest.of(pgNo, pgSize, status?Direction.ASC:Direction.DESC, properties);
		Page<Vaccine> page = repo.findAll(pageable);
		return page.getContent();
	}

	@Override
	public void fetchDetailsByPagination(int pageSize){
		long count = 3;
		long pagecount = count/pageSize;
		pagecount = count % pageSize == 0 ? pagecount : ++pagecount;
		
		for(int i = 0; i < pagecount; i++){
			PageRequest pageable = PageRequest.of(i, pageSize);
			Page<Vaccine> page = repo.findAll(pageable);
			page.getContent().forEach(v->System.out.println(v.getVaccineName()+" "+v.getVaccineCompany()));
		}
	}
}
