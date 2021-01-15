package com.alvesjefs.zuulmerce.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvesjefs.zuulmerce.domain.Computers;
import com.alvesjefs.zuulmerce.dto.ComputersDTO;
import com.alvesjefs.zuulmerce.repositories.ComputersRepository;
import com.alvesjefs.zuulmerce.services.exceptions.NameNotFoundException;

@Service
public class ComputersService {

	@Autowired
	private ComputersRepository computersRepository;

	@Transactional(readOnly = true)
	public List<ComputersDTO> findAll() {
		List<Computers> findAll = computersRepository.findAll();
		return findAll.stream().map(x -> new ComputersDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Page<ComputersDTO> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Computers> pageFind = computersRepository.findAll(pageRequest);
		return pageFind.map(x -> new ComputersDTO(x));
	}

	@Transactional(readOnly = true)
	public Computers findByName(String name) {
		Computers findName = computersRepository.findByName(name);
		if (findName == null) {
			throw new NameNotFoundException("Name not found!");
		}
		return findName;
	}
}
