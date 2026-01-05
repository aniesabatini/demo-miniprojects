package com.example.demo.Service;

import java.util.Optional;

import com.example.demo.entity.Users;

public interface UserServiceinterface {
	public Optional<Users> getUser(int id) ;
}
