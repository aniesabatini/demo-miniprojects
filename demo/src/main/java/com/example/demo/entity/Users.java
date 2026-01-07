package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String password;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference 
    private List<Connection> connections;

    public Users() {}

    public Users(Integer id, String name, String email, String password, Address address, List<Connection> connections) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.connections = connections;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public List<Connection> getConnections() { return connections; }
    public void setConnections(List<Connection> connections) { this.connections = connections; }

    @Override
    public String toString() {
        return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address=" + address + "]";
    }
}
