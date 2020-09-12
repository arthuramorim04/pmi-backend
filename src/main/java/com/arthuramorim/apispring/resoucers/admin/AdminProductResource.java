package com.arthuramorim.apispring.resoucers.admin;

import com.arthuramorim.apispring.entity.Category;
import com.arthuramorim.apispring.entity.Product;
import com.arthuramorim.apispring.services.CategoryService;
import com.arthuramorim.apispring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/admin/product/manager")
public class AdminProductResource {

    @Autowired
    private ProductService productService;

    @PostMapping("/products/add-new-product")
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {


        productService.insert(product);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();
        return ResponseEntity.created(uri).body(product);
    }

    @DeleteMapping("/product/remove-product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @Autowired
    private CategoryService categoryService;

    @PostMapping("/categorys/add-new-category")
    public ResponseEntity<Category> insertCategory(@RequestBody Category category) {
        categoryService.insert(category);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();
        return ResponseEntity.created(uri).body(category);
    }

    @DeleteMapping("/categorys/remove-category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
