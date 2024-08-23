package com.hycu.bookstore.repository;

import com.hycu.bookstore.entity.Order;
import com.hycu.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
