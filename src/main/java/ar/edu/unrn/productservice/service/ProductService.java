package ar.edu.unrn.productservice.service;

import ar.edu.unrn.productservice.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO getProductById(Long id);

    List<ProductDTO> getProducts();
}
