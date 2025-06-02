package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.User1;

@Repository
public interface User1Repository extends JpaRepository<User1,Integer>{

}
