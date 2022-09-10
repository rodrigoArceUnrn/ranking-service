package ar.edu.unrn.productservice.controller;

import ar.edu.unrn.productservice.exception.ProductUnknownException;
import ar.edu.unrn.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(productService.getProductById(id));
        } catch (ProductUnknownException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity getProducts(@PageableDefault Pageable pageable) {
        try {
            return ResponseEntity.ok().body(productService.getProducts(pageable));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
