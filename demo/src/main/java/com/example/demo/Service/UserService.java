package com.example.demo.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ConnectionRepo;
import com.example.demo.Repository.UserRepo;
import com.example.demo.entity.Connection;
import com.example.demo.entity.UpdateConnection;
import com.example.demo.entity.Users;





@Service
public class UserService  {

	
	private final UserRepo userRepo;
	private final ConnectionRepo connectionRepo;
	
	 public UserService(UserRepo userRepo, ConnectionRepo connectionRepo) {
	        this.userRepo = userRepo;
	        this.connectionRepo = connectionRepo;
	    }


    
	public Optional<Users> getUser(int id) {
		return userRepo.findById(id);
	}


	public Users createUser(Users users) {
		// TODO Auto-generated method stub
		return userRepo.save(users);
	}


	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}


	public Optional<Connection> getConnectionById(int id) {
		// TODO Auto-generated method stub
		return connectionRepo.findById(id);
	}


	public Connection updateConnection(Integer id, UpdateConnection updateConnection) {
		// TODO Auto-generated method stub
    	
    	System.out.println(connectionRepo.findById(id));

		Connection connection= connectionRepo.findById(id).orElseThrow(()->new RuntimeException("Connection not found"));
		connection.setStatus(updateConnection.getStatus());
		return connection;
	}



	public Connection createConnectionById(Integer id,Connection connection) {
		
		Users opt=userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));
		System.out.println("bepost");
		connection.setUser(opt);
		System.out.println("aaf");

		// TODO Auto-generated method stub
		return connectionRepo.save(connection);
	}



	


	}
