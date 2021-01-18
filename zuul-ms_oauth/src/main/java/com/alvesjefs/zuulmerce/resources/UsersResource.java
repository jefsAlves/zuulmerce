package com.alvesjefs.zuulmerce.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvesjefs.zuulmerce.domain.Users;
import com.alvesjefs.zuulmerce.services.UsersService;

@RestController
@RequestMapping(value = "api/users")
public class UsersResource {

	@Autowired
	private UsersService usersService;

	@GetMapping(value = "/searchEmail")
	public ResponseEntity<Users> findByEmail(@RequestParam String email) {
		Users findEmail = usersService.findByEmail(email);
		return ResponseEntity.ok().body(findEmail);
	}
}
