package com.sb.PageAndSortRepo.service;

import com.sb.PageAndSortRepo.entity.VaccineDetails;

public interface IVaccineManagement {
	// PagingAndSortingRepository
    public Iterable<VaccineDetails> fetchSortedDetail(boolean status, String...properties);
    public Iterable<VaccineDetails>fetchDetailsByPageNo(int pgNo, int pgSize, boolean status, String...properties);
    public void fetchDetailsByPagination(int pgSize);
}
