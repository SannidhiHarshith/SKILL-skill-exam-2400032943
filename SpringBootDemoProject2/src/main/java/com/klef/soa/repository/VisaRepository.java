package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Visa;


@Repository
public interface VisaRepository extends JpaRepository<Visa,Long> {

	
	List<Visa> findByName(String name);
	
	List<Visa> findByType(String type);
}
