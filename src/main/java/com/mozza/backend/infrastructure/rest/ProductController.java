package com.mozza.backend.infrastructure.rest;


import com.mozza.backend.application.ProductService;
import com.mozza.backend.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        log.info("Producto {}",product.getName());
        return  new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Product>> findAll(){
        return  ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id){
        productService.deleteById(id);
         return ResponseEntity.ok().build();

    }



}
