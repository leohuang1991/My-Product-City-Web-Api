package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Product1;


@Repository
public interface Product1Repository extends JpaRepository<Product1,Integer>{

	@Query("select a from Product1 a where a.username=?1 ")
	List<Product1> findByusername(String dd);
}
