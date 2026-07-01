package com.tka.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dto.UserRequestDto;
import com.tka.dto.UserResponseDto;
import com.tka.entity.User;
import com.tka.enums.Role;
import com.tka.reposistory.UserReposistory;
import com.tka.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserReposistory userReposistory;

	@Override
	public UserResponseDto saveUser(UserRequestDto dto) {
		User user = new User();

		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setMobileNumber(dto.getMobileNumber());
		user.setRole(Role.CUSTOMER);

		User savedUser = userReposistory.save(user);

		UserResponseDto response = new UserResponseDto();

		response.setId(savedUser.getId());
		response.setFirstName(savedUser.getFirstName());
		response.setLastName(savedUser.getLastName());
		response.setEmail(savedUser.getEmail());
		response.setMobileNumber(savedUser.getMobileNumber());
		response.setRole(savedUser.getRole());

		return response;
	}

	@Override
	public List<UserResponseDto> getAllUser() {
		List<User> users = userReposistory.findAll();

		List<UserResponseDto> responseList = new ArrayList<>();

		for (User user : users) {

			UserResponseDto response = new UserResponseDto();

			response.setId(user.getId());
			response.setFirstName(user.getFirstName());
			response.setLastName(user.getLastName());
			response.setEmail(user.getEmail());
			response.setMobileNumber(user.getMobileNumber());
			response.setRole(user.getRole());

			responseList.add(response);
		}

		return responseList;
	}

	@Override
	public UserResponseDto gteUserById(Long id) {
		User user = userReposistory.findById(id).orElse(null);

		if (user == null) {
			return null;
		}

		UserResponseDto response = new UserResponseDto();

		response.setId(user.getId());
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setEmail(user.getEmail());
		response.setMobileNumber(user.getMobileNumber());
		response.setRole(user.getRole());

		return response;
	}

	@Override
	public void deleteById(Long id) {
		userReposistory.deleteById(id);
	}

	@Override
	public UserResponseDto updateUser(Long id, UserRequestDto dto) {
		User oldUser = userReposistory.findById(id).orElse(null);

		if (oldUser == null) {
			return null;
		}

		oldUser.setFirstName(dto.getFirstName());
		oldUser.setLastName(dto.getLastName());
		oldUser.setEmail(dto.getEmail());
		oldUser.setPassword(dto.getPassword());
		oldUser.setMobileNumber(dto.getMobileNumber());
		oldUser.setRole(dto.getRole());

		User updatedUser = userReposistory.save(oldUser);

		UserResponseDto response = new UserResponseDto();

		response.setId(updatedUser.getId());
		response.setFirstName(updatedUser.getFirstName());
		response.setLastName(updatedUser.getLastName());
		response.setEmail(updatedUser.getEmail());
		response.setMobileNumber(updatedUser.getMobileNumber());
		response.setRole(updatedUser.getRole());

		return response;
	}

	@Override
	public UserResponseDto findByEmail(String email) {
		User user = userReposistory.findByEmail(email).orElseThrow(()->new RuntimeException("user not found"));

		UserResponseDto response = new UserResponseDto();
		response.setId(user.getId());
		response.setFirstName(user.getFirstName());
		response.setEmail(user.getEmail());

		return response;
	}

}
