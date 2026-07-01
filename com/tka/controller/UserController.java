package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.dto.UserRequestDto;
import com.tka.dto.UserResponseDto;
import com.tka.entity.User;
import com.tka.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/save")
	public UserResponseDto saveUser(@Valid @RequestBody UserRequestDto dto) {
		return userService.saveUser(dto);
	}

	@GetMapping("/all")
	public List<UserResponseDto> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping("/getById/{id}")
	public UserResponseDto gteUserById(@PathVariable Long id) {
		return userService.gteUserById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable Long id) {
		userService.deleteById(id);
	}

	@PutMapping("/update/{id}")
	public UserResponseDto updateuser(@PathVariable Long id, @Valid @RequestBody UserRequestDto dto) {
		return userService.updateUser(id, dto);

	}

}
