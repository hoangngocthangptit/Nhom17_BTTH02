package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.service;
import com.example.demo.entity.Product;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private service ProductService;

	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value ="/listproduct" ,method = RequestMethod.GET)
	public String getProduct(Model model) {
		List<Product> users = ProductService.getAllUser();
		model.addAttribute("users", users);
		return "listproduct";
	}

	@RequestMapping(value = "insert")
	public String addUser(Model model) {
		model.addAttribute("user", new Product());
		return "insert";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUser(@RequestParam("id") Long userId, Model model) {
		Optional<Product> userEdit = ProductService.findUserById(userId);
		userEdit.ifPresent(user -> model.addAttribute("user", user));
		return "update";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Product user) {
		ProductService.save(user);
		return "redirect:/listproduct";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") Long userId, Model model) {
		ProductService.delete(userId);
		return "redirect:/listproduct";
	}
}
