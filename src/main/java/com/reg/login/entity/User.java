package com.reg.login.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String email;
	private String password;
	private String role;
	private String fullname;
	
	
	
}
