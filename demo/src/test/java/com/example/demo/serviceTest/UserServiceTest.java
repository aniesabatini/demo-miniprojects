package com.example.demo.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.Repository.UserRepo;
import com.example.demo.Service.UserService;
import com.example.demo.entity.Users;

public class UserServiceTest {
    
    @Mock
    private UserRepo userRepo;
    
    @InjectMocks
    private UserService userService;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }
    
    @Test
    void testGetUser() {
        // Arrange
        Users user = new Users();
        user.setId(1);
        user.setName("anie");

        // Mock repository behavior
        when(userRepo.findById(1)).thenReturn(Optional.of(user));

        // Act
        Optional<Users> result = userService.getUser(1);

        // Assert
        assertEquals("anie", result.get().getName());
    }
    
    @Test
    void testNotFoundUser() {
        Users user = new Users();

    	when(userRepo.findById(2)).thenReturn(Optional.empty());
    	Optional<Users> result= userService.getUser(1);
    	assertTrue(result.isEmpty());
    }
}
