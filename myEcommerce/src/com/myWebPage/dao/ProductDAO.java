package com.myWebPage.dao;

import java.util.List;

import com.myWebPage.model.Product;

public interface ProductDAO {
	
	void addProduct(Product product);

    Product getProductById(String id);

    List<Product> getAllProducts();

    void deleteProduct(String id);
    
    void editProduct(Product product);

}
