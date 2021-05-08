package com.project.shareMed.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shareMed.entites.Product;

public interface ProductDao extends JpaRepository<Product, Long>{
	
}
