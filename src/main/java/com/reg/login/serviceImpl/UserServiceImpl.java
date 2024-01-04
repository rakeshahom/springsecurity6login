package com.reg.login.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.reg.login.Dto.UserDto;
import com.reg.login.entity.User;
import com.reg.login.repositories.UserRepo;
import com.reg.login.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User save(UserDto userDto) {
		User user = new User(0, userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()),  userDto.getRole(),userDto.getFullname());
		return userRepo.save(user);
	}

}
