package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.entity.Users;

@RestController
@RequestMapping("/users")

public class telecontroller{
	
	
	private final UserService userService;
	
	
	public telecontroller(UserService userService) {
		super();
		this.userService = userService;
	}


	@GetMapping("/{id}")
	public ResponseEntity<Users> getusers(@PathVariable int id ) {
		Optional<Users> opt= userService.getUser(id);
		if(opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/create")
	public Users CreateUser(@RequestBody Users users) {
		return userService.createUser(users);
	}
}