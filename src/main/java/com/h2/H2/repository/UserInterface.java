package com.h2.H2.repository;

import com.h2.H2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInterface extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);

}
