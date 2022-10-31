package ar.edu.unrn.rankingservice.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rankings")
public class Ranking extends BaseEntity{

    @Column(name = "cant_star")
    private Float cantStar;
    private String description;
    private LocalDateTime date;
    @Column(name = "product_id")
    private Long productId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id")
    private Client client;

    public Ranking() {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
