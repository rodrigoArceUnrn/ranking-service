package ar.edu.unrn.rankingservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RankingDTO {

    private Long id;
    private Float cantStar;
    private String description;
    private LocalDateTime date;
    private Long productId;
    private ClientDTO client;
}