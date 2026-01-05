package com.example.demo.Service;

<<<<<<< HEAD
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.Repository.*;


@Service
public class UserService implements UserServiceinterface {

	
	private final UserRepo userRepo;
	
	
	
	public UserService(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}


    @Override
	public Optional<Users> getUser(int id) {
		return userRepo.findById(id);
	}


	public Users createUser(Users users) {
		// TODO Auto-generated method stub
		return userRepo.save(users);
	}
=======
public class UserService {

>>>>>>> branch 'master' of https://github.com/aniesabatini/demo-miniprojects.git
}
