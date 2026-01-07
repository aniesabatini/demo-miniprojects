package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String status;
    private String planType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore 
    private Users user;

    public Connection() {}

    public Connection(Integer id, String status, String planType, Users user) {
        this.id = id;
        this.status = status;
        this.planType = planType;
        this.user = user;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPlanType() { return planType; }
    public void setPlanType(String planType) { this.planType = planType; }

    public Users getUser() { return user; }
    public void setUser(Users user) { this.user = user; }
}
