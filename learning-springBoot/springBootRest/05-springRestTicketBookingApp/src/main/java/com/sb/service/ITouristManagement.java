package com.sb.service;

import java.util.List;

import com.sb.model.Tourist;

public interface ITouristManagement {
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourists();
	public Tourist fetchTourist(Integer id);
	public String updateTouristByDetails(Tourist tourist);
	public String updateTouristById(Integer id, Double budgetHike);
    public String deleteTouristById(Integer id);
}
