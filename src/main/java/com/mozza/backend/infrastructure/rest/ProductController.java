package com.mozza.backend.infrastructure.rest;


import com.mozza.backend.application.ProductService;
import com.mozza.backend.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestParam("id") Long id,
                                        @RequestParam("code") String code,
                                        @RequestParam("name") String name,
                                        @RequestParam("description") String description,
                                        @RequestParam("price")BigDecimal price,
                                        @RequestParam("urlImage") String urlImage,
                                        @RequestParam("userId") Long userId,
                                        @RequestParam("categoryId") Long categoryId,
                                        @RequestParam(value = "image",required = false)MultipartFile multipartFile
                                        ) throws IOException {
        Product product = new Product();
        product.setId(id);
        product.setCode(code);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategoryId(categoryId);
        product.setUserId(userId);
        product.setUrlImage(urlImage);


        log.info("Producto {}",product.getName());
        return  new ResponseEntity<>(productService.save(product,multipartFile),HttpStatus.CREATED);
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
