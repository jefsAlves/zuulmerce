package com.alvesjefs.zuulmerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvesjefs.zuulmerce.domain.Monitor;
import com.alvesjefs.zuulmerce.repositories.MonitorRepository;

@Service
public class MonitorService {

	@Autowired
	private MonitorRepository monitorRepository;

	public Monitor findByName(String name) {
		Monitor findName = monitorRepository.findByName(name);
		return findName;
	}
}
