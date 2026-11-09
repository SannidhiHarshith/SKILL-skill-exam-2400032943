package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.klef.soa.entity.Visa;
import com.klef.soa.service.VisaService;

@RestController
@RequestMapping("/visa")
public class VisaController {
	
	@Autowired
	private VisaService service;
	
	
	@GetMapping("/")
	public ResponseEntity<String> demo() {
	    return ResponseEntity.ok("Project is Running");
	}
	
	
	// to add new record
	@PostMapping("/add")
	public ResponseEntity<Visa> addVisa(@RequestBody Visa v)
	{
		Visa visa = service.addVisa(v);
		return ResponseEntity.status(201).body(visa);  //status code and entity
	    
	}
	
	// to display visa by id
	@GetMapping("/display")
	public ResponseEntity<?> displayVisaById(@RequestParam Long id)
	{
		Visa visa = service.displayVisaById(id);

		if (visa != null)
		{
			return ResponseEntity.status(200).body(visa);
		}
		else
		{
			return ResponseEntity.status(404).body("Doctor ID Not Found");
		}
	}
	
	// to display all records in Visa
	@GetMapping("/displayall")
	public ResponseEntity<List<Visa>> displayAllVisa()
	{
		List<Visa> doctors = service.displayAllVisa();
		return ResponseEntity.status(200).body(doctors);
	}
	
	// to update the existing record
	@PutMapping("/update")
	public ResponseEntity<?> updateVisa(@RequestBody Visa visa)
	{
		Visa v = service.updateVisa(visa);

		if (v != null)
		{
			return ResponseEntity.ok(v);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor ID Not Found");
		}
	}
	
	
	// to delete the visa record by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteVisaById(@PathVariable Long id)
	{
		String message = service.deleteVisaById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
	// to display by name
	@GetMapping("/displaybyname/{name}")
	public ResponseEntity<List<Visa>> displayVisaByName(@PathVariable String name)
	{
		List<Visa> visa = service.displayVisaByName(name);
		return ResponseEntity.status(200).body(visa);
	}
	
	// to display by type
	@GetMapping("/displaybytype/{type}")
	public ResponseEntity<List<Visa>> displayVisaByType(@PathVariable String type)
	{
		List<Visa> visaaa = service.displayVisaByType(type);
		return ResponseEntity.status(200).body(visaaa);
	}
	
	


}
