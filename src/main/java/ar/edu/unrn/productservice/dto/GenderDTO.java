package ar.edu.unrn.productservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


public class GenderDTO {

    private Long id;

    private String description;

    @JsonIgnore
    private List<ProductDTO> productList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDTO> productList) {
        this.productList = productList;
    }
}
