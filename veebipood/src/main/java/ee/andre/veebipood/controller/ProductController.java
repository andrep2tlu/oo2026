package ee.andre.veebipood.controller;

import ee.andre.veebipood.entity.Product;
import ee.andre.veebipood.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @DeleteMapping("delete/{id}")
    public List<Product> deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    @PostMapping("addproduct")
    public List<Product> addProduct(@RequestBody Product product){
        productRepository.save(product);
        return productRepository.findAll();
    }


}