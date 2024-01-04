package com.reg.login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reg.login.entity.User;
import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email);
}
