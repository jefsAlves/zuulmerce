package com.alvesjefs.zuulmerce.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvesjefs.zuulmerce.domain.Monitor;
import com.alvesjefs.zuulmerce.services.MonitorService;

@RestController
@RequestMapping("api/monitor")
public class MonitorResource {

	@Autowired
	private MonitorService monitorService;

	@GetMapping(value = "/searchName")
	public ResponseEntity<Monitor> findByName(@RequestParam String name) {
		Monitor findName = monitorService.findByName(name);
		return ResponseEntity.ok().body(findName);
	}
}
