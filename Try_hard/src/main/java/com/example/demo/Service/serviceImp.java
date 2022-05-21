package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.repository;
@Service
public class serviceImp implements service{
	@Autowired
	private repository Repository;
	@Override
	public List<Product> getAllUser() {
		return (List<Product>)Repository.findAll()
;	}

	@Override
	public void save(Product product) {
		 Repository.save(product);
		
	}

	@Override
	public void delete(Long id) {
		Repository.deleteById(id);		
	}

	@Override
	public Optional<Product> findUserById(Long id) {
		return Repository.findById(id);
	}
	

}
