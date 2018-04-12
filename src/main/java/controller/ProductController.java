package controller;


import java.math.BigDecimal;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Product;
import service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/add-product")
	public String addProduct() {
		return "product/add-product";
	}
	
	@PostMapping("/add-product")
	public String saveProduct(
			@RequestParam("productName") String productName,
			@RequestParam("productDescription") String description,
			@RequestParam("productPrice") String price
			) {
		
		System.out.println(">"+productName+" "+description+" "+price);
		
		Product product = new Product();
		product.setName(productName);
		product.setDescription(description);
		product.setPrice(new BigDecimal(price+".00"));
		
		productService.saveProduct(product);
		
		return "redirect:/";
	}
	
	@GetMapping("/products")
	public String showProducts(Model model) {
		//List<Product> products = productService.findAllProducts();
		//model.addAttribute("productsList", products);
		model.addAttribute("productsList",productService.findAllProducts());
		model.addAttribute("pageTitle", "Products page" );
		return "product/products";
	}
	
	@GetMapping("/{product.id}")
	public String showProductById(
			@PathVariable("product.id") int productId,
			Model model
			) {
		System.out.println("Product ID: "+productId);
		
		model.addAttribute("title", "Product Details");
		
		Product product = productService.findProductById(productId);
		//model.addAttribute("productModel", product);
		System.out.println(product.toString());
		//model.addAttribute("productModel", productService.findProductById(productId));
		model.addAttribute("productModel",product);
		
		return "product/product";
	}
	
	@GetMapping("/del/{productId}")
	public String deleteProductById(
			@PathVariable("productId") int id
			) {
		productService.deleteProductById(id);
		return "redirect:/product/products";
	}
	
	@GetMapping("/edit/{productId}")
	public String editProductById(
			@PathVariable("productId") int productId, Model model) {
		model.addAttribute("productModel",productService.findProductById(productId));
		return "product/edit";
	}
	
	@PostMapping("/edit-product")
	public String editProduct(
			@RequestParam("productName") String productName,
			@RequestParam("productDescription") String description,
			@RequestParam("productPrice") String price,
			@RequestParam("productId") String productIdStr
			) {
		
				
		Product product = new Product();
		product.setId(Integer.valueOf(productIdStr));
		product.setName(productName);
		product.setDescription(description);
		product.setPrice(new BigDecimal(price+".00"));
		
		productService.saveProduct(product);
		
		return "redirect:/";
	}
	
	
	
	

}
