package com.tka.service;

import java.util.List;

import com.tka.dto.UserRequestDto;
import com.tka.dto.UserResponseDto;

public interface UserService {
	UserResponseDto saveUser(UserRequestDto user);

	List<UserResponseDto> getAllUser();

	UserResponseDto gteUserById(Long id);

	void deleteById(Long id);

	UserResponseDto updateUser(Long id, UserRequestDto user);
	
	UserResponseDto findByEmail(String email);
}
