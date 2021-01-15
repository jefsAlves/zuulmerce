package com.alvesjefs.zuulmerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.zuulmerce.domain.Computers;

public interface ComputersRepository extends JpaRepository<Computers, Long> {

	Computers findByName(String name);	
}
