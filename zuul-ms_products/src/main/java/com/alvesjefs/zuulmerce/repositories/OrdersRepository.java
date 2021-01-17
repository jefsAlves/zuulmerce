package com.alvesjefs.zuulmerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvesjefs.zuulmerce.domain.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
