package com.alvesjefs.zuulmerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alvesjefs.zuulmerce.domain.Roles;
import com.alvesjefs.zuulmerce.domain.Users;
import com.alvesjefs.zuulmerce.dto.RolesDTO;
import com.alvesjefs.zuulmerce.dto.UsersDTO;
import com.alvesjefs.zuulmerce.repositories.RolesRepository;
import com.alvesjefs.zuulmerce.repositories.UsersRepository;
import com.alvesjefs.zuulmerce.services.exceptions.EmailNotFoundException;
import com.alvesjefs.zuulmerce.services.exceptions.IdNotFoundException;
import com.alvesjefs.zuulmerce.services.exceptions.NameNotFoundException;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RolesRepository rolesRepository;

	@Transactional(readOnly = true)
	public Users findById(Long id) {
		Optional<Users> findId = usersRepository.findById(id);
		return findId.orElseThrow(() -> new IdNotFoundException("Id not found!"));
	}

	public Users findByEmail(String email) {
		Users findEmail = usersRepository.findByEmail(email);
		if (findEmail == null) {
			throw new EmailNotFoundException("Email not found!");
		}

		return findEmail;
	}

	@Transactional(readOnly = true)
	public Users findByName(String name) {
		Users findName = usersRepository.findByName(name);
		if (findName == null) {
			throw new NameNotFoundException("Name not found!");
		}
		return findName;
	}

	@Transactional(readOnly = true)
	public Page<UsersDTO> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<Users> findPage = usersRepository.findAll(pageRequest);
		return findPage.map(x -> new UsersDTO(x));
	}

	@Transactional
	public UsersDTO insertClient(UsersDTO usersDTO) {
		Users users = new Users(null, usersDTO.getName(), usersDTO.getEmail(), usersDTO.getPassword(),
				usersDTO.getCpf());
		for (RolesDTO rolesDTO : usersDTO.getRoles()) {
			Roles roles = rolesRepository.getOne(rolesDTO.getId());
			users.getRoles().add(roles);
		}

		users = usersRepository.save(users);
		return new UsersDTO(users);
	}
}
