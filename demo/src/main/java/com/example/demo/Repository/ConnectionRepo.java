package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.aot.JpaRepositoryContributor;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Connection;

@Repository
public interface ConnectionRepo extends JpaRepository<Connection , Integer> {

}
