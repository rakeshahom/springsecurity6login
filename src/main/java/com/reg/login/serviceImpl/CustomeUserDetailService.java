package com.reg.login.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reg.login.entity.User;
import com.reg.login.repositories.UserRepo;

@Service
public class CustomeUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userRepo.findByEmail(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("this "+username+" Not Found ..!");
		}
		return new CustomUserDetails(user);
	}

}
