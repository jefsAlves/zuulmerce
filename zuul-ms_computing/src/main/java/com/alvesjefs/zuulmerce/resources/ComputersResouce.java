package com.alvesjefs.zuulmerce.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvesjefs.zuulmerce.domain.Computers;
import com.alvesjefs.zuulmerce.dto.ComputersDTO;
import com.alvesjefs.zuulmerce.services.ComputersService;

@RestController
@RequestMapping(value = "api/computers")
public class ComputersResouce {

	@Autowired
	private ComputersService computersService;

	@GetMapping
	public ResponseEntity<List<ComputersDTO>> findAll(ComputersDTO computersDTO) {
		List<ComputersDTO> findAll = computersService.findAll();
		return ResponseEntity.ok().body(findAll);
	}

	@GetMapping(value = "/searchPage")
	public ResponseEntity<Page<ComputersDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
		Page<ComputersDTO> findPage = computersService.findPage(page, linesPerPage, direction, orderBy);
		return ResponseEntity.ok().body(findPage);
	}

	@GetMapping(value = "/searchName")
	public ResponseEntity<Computers> findByName(String name) {
		Computers findName = computersService.findByName(name);
		return ResponseEntity.ok().body(findName);
	}

}
