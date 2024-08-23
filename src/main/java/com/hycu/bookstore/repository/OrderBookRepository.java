package com.hycu.bookstore.repository;

import com.hycu.bookstore.entity.OrderBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {}
