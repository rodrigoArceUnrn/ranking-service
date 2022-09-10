package ar.edu.unrn.productservice.controller;

import ar.edu.unrn.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "/products")
public class ProductController {


    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) {
        try {
            return (ResponseEntity) ResponseEntity.ok();//.body(productService.getProductById(id));
        } catch (Exception e) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping()
    public ResponseEntity getProducts() {
        try {
            return (ResponseEntity) ResponseEntity.ok();//.body(productService.getProducts());
        } catch (Exception e) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
