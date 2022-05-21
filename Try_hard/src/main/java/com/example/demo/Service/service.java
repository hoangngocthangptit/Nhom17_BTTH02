package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Product;

public interface service {
	List<Product> getAllUser();
	void save(Product product);
	void delete(Long id);
	Optional<Product> findUserById(Long id);
	
}
