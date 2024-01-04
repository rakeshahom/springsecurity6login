package com.reg.login.services;

import com.reg.login.Dto.UserDto;
import com.reg.login.entity.User;

public interface UserService {

	User save(UserDto userDto);
}
