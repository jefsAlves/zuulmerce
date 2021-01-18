package com.alvesjefs.zuulmerce.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alvesjefs.zuulmerce.domain.Users;
import com.alvesjefs.zuulmerce.dto.UsersDTO;
import com.alvesjefs.zuulmerce.services.UsersService;

@RestController
@RequestMapping(value = "api/users")
public class UsersResource {

	@Autowired
	private UsersService usersService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Users> findById(@PathVariable Long id) {
		Users findId = usersService.findById(id);
		return ResponseEntity.ok().body(findId);
	}

	@GetMapping(value = "/searchName")
	public ResponseEntity<Users> findByName(@RequestParam String name) {
		Users findName = usersService.findByName(name);
		return ResponseEntity.ok().body(findName);
	}

	@GetMapping(value = "/searchPage")
	public ResponseEntity<Page<UsersDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {
		Page<UsersDTO> findPage = usersService.findPage(page, linesPerPage, direction, orderBy);
		return ResponseEntity.ok().body(findPage);
	}

	@PostMapping
	public ResponseEntity<UsersDTO> insertClient(UsersDTO usersDTO) {
		UsersDTO insertClient = usersService.insertClient(usersDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usersDTO.getId())
				.toUri();
		return ResponseEntity.created(uri).body(insertClient);
	}

}
