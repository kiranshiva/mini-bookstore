package com.hycu.bookstore.repository;

import com.hycu.bookstore.entity.Book;
import com.hycu.bookstore.entity.Cart;
import com.hycu.bookstore.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(User user);

    @Modifying
    @Transactional
    @Query(value = "delete from cart u where u.user_id = :userId",nativeQuery = true)
    void deleteCartByUserID(@Param("userId") Long userId);

    Cart findByUserAndBook(User user, Book book);
}
