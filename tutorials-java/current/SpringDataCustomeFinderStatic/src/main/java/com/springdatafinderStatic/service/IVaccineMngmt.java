package com.springdatafinderStatic.service;

import java.util.List;

import com.springdatafinderStatic.type.ResultView;




public interface IVaccineMngmt 
{
   public List<ResultView>  searchVaccineByStartPrice(Integer price);

}
