package com.alvesjefs.zuulmerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.zuulmerce.domain.Monitor;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {

	Monitor findByName(String name);
}
