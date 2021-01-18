package com.alvesjefs.zuulmerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alvesjefs.zuulmerce.domain.Users;
import com.alvesjefs.zuulmerce.feignclients.UsersFeignClient;
import com.alvesjefs.zuulmerce.services.exceptions.EmailNotFoundException;

@Service
public class UsersService implements UserDetailsService {

	@Autowired
	private UsersFeignClient usersFeignClient;

	public Users findByEmail(String email) {
		Users findEmail = usersFeignClient.findByEmail(email).getBody();
		if (findEmail == null) {
			throw new EmailNotFoundException("Email not found!");
		}

		return findEmail;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users findEmail = usersFeignClient.findByEmail(username).getBody();
		if (findEmail == null) {
			throw new UsernameNotFoundException("Email not found!");
		}

		return findEmail;
	}
}
