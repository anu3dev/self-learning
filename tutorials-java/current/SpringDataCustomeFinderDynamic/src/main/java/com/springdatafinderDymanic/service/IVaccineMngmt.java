package com.springdatafinderDymanic.service;

import java.util.List;

import com.springdatafinderDymanic.type.View;




public interface IVaccineMngmt 
{
	public <T extends View>List<T> searchByVaccineCompany(String companyName, Class<T> cls);

}
