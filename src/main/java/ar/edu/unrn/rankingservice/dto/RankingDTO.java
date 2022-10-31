package ar.edu.unrn.rankingservice.dto;

import java.time.LocalDateTime;

public class RankingDTO {

    private Long id;
    private Float cantStar;
    private String description;
    private LocalDateTime date;
    private Long productId;

    private ClientDTO client;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCantStar() {
        return cantStar;
    }

    public void setCantStar(Float cantStar) {
        this.cantStar = cantStar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }
}
