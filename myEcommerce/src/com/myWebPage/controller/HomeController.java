package com.myWebPage.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myWebPage.dao.ProductDAO;
import com.myWebPage.model.Product;

@Controller
public class HomeController {


	@Autowired
	private ProductDAO productDao;

	@RequestMapping("/")
	public String showHome() {
		return "Home";
	}

	@RequestMapping("/productList")
	public String getProducts(Model model) {
		List<Product> products = productDao.getAllProducts();
		model.addAttribute("products", products);

		return "productList";
	}

	@RequestMapping("/productList/viewProduct/{productId}")
	public String viewProduct(@PathVariable String productId, Model model) throws IOException {

		Product product = productDao.getProductById(productId);
		model.addAttribute(product);

		return "viewProduct";
	}

	
}
