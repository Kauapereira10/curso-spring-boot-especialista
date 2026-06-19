package com.udemy.curso.kaua.produtosapi.controller;

import com.udemy.curso.kaua.produtosapi.model.Product;
import com.udemy.curso.kaua.produtosapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
// URL desse controller
@RequestMapping("products")
public class ProductController {

    private ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Product salvar(@RequestBody Product product) {
        System.out.println("Produto cadastrado: " + product);
        var id = UUID.randomUUID().toString();
        product.setId(id);
        repository.save(product);
        return product;
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") String id) {
        // Optional<Product> product = repository.findById(id);
        // return product.isPresent() ? product.get() : null;

        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id, @RequestBody Product product) {
        product.setId(id);
        repository.save(product);
    }


//    @GetMapping("/{name}")
//    public List<Product> getByName(@RequestParam("name") String name) {
//        return repository.findByName(name);
//    }
//
//    @GetMapping("/{price}")
//    public List<Product> getByPrice(@RequestParam("price") Double price) {
//        return repository.findByPrice(price);
//    }
//
//    @GetMapping("/{description}")
//    public List<Product> getByDescription(@RequestParam("description") String description) {
//        return repository.findByDescription(description);
//    }

    @GetMapping
    public List<Product> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String description) {

        if(name != null) {
            return repository.findByName(name);
        }
        if (price != null) {
            return repository.findByPrice(price);
        }
        if (description != null) {
            return repository.findByDescription(description);
        }

        return repository.findAll();

    }
}

