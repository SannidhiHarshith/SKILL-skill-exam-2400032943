package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Visa;


public interface VisaService {
	
	Visa addVisa(Visa v);//
	Visa updateVisa(Visa v);//
	String deleteVisaById(Long id);//
	List<Visa> displayAllVisa();//
	Visa displayVisaById(Long id);//
	List<Visa> displayVisaByName(String name);
	List<Visa> displayVisaByType(String type);
	

}
