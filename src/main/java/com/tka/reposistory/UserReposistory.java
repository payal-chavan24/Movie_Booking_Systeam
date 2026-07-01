package com.tka.reposistory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tka.entity.User;

public interface UserReposistory extends JpaRepository<User, Long> {
	 Optional<User> findByEmail(String email);
}
