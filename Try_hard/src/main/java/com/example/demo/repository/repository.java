package com.example.demo.repository;

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Product;


@org.springframework.stereotype.Repository
public interface repository extends CrudRepository<Product, Long>{

}
