package com.alvesjefs.zuulmerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.zuulmerce.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByName(String name);
}
