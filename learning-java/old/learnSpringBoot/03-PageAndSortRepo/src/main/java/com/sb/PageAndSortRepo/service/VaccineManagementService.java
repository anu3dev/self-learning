package com.sb.PageAndSortRepo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sb.PageAndSortRepo.entity.VaccineDetails;
import com.sb.PageAndSortRepo.entity.VaccineRepoPageAndSort;

@Service("vservice")
public class VaccineManagementService implements IVaccineManagement {
	@Autowired
	private VaccineRepoPageAndSort pageAndSortRepo;
	
	@Override
	public Iterable<VaccineDetails> fetchSortedDetail(boolean status, String... properties) {
		Sort sort = Sort.by(status ? Direction.ASC : Direction.DESC, properties);
		Iterable<VaccineDetails> sortedList = pageAndSortRepo.findAll(sort);
		return sortedList;
	}
	
	@Override
	public Iterable<VaccineDetails> fetchDetailsByPageNo(int pgNo, int pgSize, boolean status, String... properties) {
		 PageRequest pageable = PageRequest.of(pgNo, pgSize, status ? Direction.ASC : Direction.DESC, properties);
		 Page<VaccineDetails> page = pageAndSortRepo.findAll(pageable);
		 return page.getContent();
	}

	@Override
	public void fetchDetailsByPagination(int pgSize) {
		long count=7L;
		long pagescount = count/pgSize;
	    
	    pagescount = count%pgSize == 0 ? pagescount : ++pagescount;
	    
	    for(int i=0; i < pagescount ; i++ ) {
	    	Pageable pageable = PageRequest.of(i, pgSize);
	    	Page<VaccineDetails> page = pageAndSortRepo.findAll(pageable);
	    	page.getContent().forEach(vaccine -> System.out.println(vaccine));
	    	
	    	System.out.println("************>>>" + (i+1) + " of "+ page.getTotalPages());
	    }
	}
}
