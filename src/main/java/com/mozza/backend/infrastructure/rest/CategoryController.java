package com.mozza.backend.infrastructure.rest;


import com.mozza.backend.application.CategoryService;
import com.mozza.backend.domain.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category){

        return  ResponseEntity.ok(categoryService.save(category));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok(this.categoryService.findById(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Category>> findAll(){
        return  ResponseEntity.ok(categoryService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){

        categoryService.deleteById(id);

    }


}
