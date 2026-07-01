package com.tka.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.dto.LoginRequestDto;
import com.tka.entity.User;
import com.tka.reposistory.UserReposistory;
import com.tka.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UserReposistory userRepository;

	@PostMapping("/login")
	public String login(@RequestBody LoginRequestDto dto) {
		Optional<User> user = userRepository.findByEmail(dto.getEmail());

		if (user.isEmpty()) {
			return "User Not Found";
		}

		User existingUser = user.get();

		if (!existingUser.getPassword().equals(dto.getPassword())) {
			return "Invalid Password";
		}

		String token = JwtUtil.generateToken(existingUser.getEmail());
		return token;

	}
}
