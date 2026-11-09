package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Visa;
import com.klef.soa.repository.VisaRepository;

@Service
public class VisaServiceImpl implements VisaService {
	
	@Autowired
	private VisaRepository repo;

	@Override
	public Visa addVisa(Visa v) {
		return repo.save(v);
	}

	@Override
	public Visa updateVisa(Visa v) {
		
		Optional<Visa> optional = repo.findById(v.getVisaid());        // here id is bounded with 'd'
		if(optional.isPresent()) {
			Visa visa = optional.get();                      //'d' is input  && 'doctor' is works if d is present
			
			
			visa.setName(v.getName());   
			visa.setStatus(v.getStatus());
			visa.setType(v.getType());
			visa.setLocation(v.getLocation());
			                                           //.save->when id is present it works as update operation
			                                            //.save->when id is not present it works as insert operation
			return repo.save(visa);
			
			
		}else {
			return null;
		}
		
	}

	@Override
	public String deleteVisaById(Long id) {
		boolean flag = repo.existsById(id); //return true or false
		if(flag) {
			repo.deleteById(id);
			return "Visa Deleted Successfully";
			
		}else {
			return "Visa ID Not Found";
		}
	}

	@Override
	public List<Visa> displayAllVisa() {
		return repo.findAll();
	}

	@Override
	public Visa displayVisaById(Long id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Visa> displayVisaByName(String name) {
		return repo.findByName(name);
	}

	@Override
	public List<Visa> displayVisaByType(String type) {
		return repo.findByType(type);
	}
	

}
