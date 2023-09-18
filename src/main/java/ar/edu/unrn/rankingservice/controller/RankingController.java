package ar.edu.unrn.rankingservice.controller;

import ar.edu.unrn.rankingservice.dto.RankingDTO;
import ar.edu.unrn.rankingservice.service.RankingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "/rankings")
public class RankingController {

    final
    RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }


    @PostMapping()
    @PreAuthorize("hasRole('ROLE_CLIENTE')")
    @Operation(summary = "Creación de puntuación a un producto.")
    public ResponseEntity<RankingDTO> createRanking(@RequestBody RankingDTO rankingDTO) {
        try {
            rankingService.create(rankingDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/product/{id}")
    @PreAuthorize("hasRole('ROLE_CLIENTE')")
    @Operation(summary = "Listar el ranking de un producto dado.")
    public ResponseEntity<Page<RankingDTO>> getRankingsByProductId(@PathVariable Long id, Pageable pageable) {
        try {
            return ResponseEntity.ok().body(rankingService.getRankingsByProductId(id, pageable));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping("/average/product/{id}")
    @PreAuthorize("hasRole('ROLE_CLIENTE')")
    @Operation(summary = "Devuelve el promedio de la puntuación dada a una producto.")
    public ResponseEntity<Float> getAverageByProductId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(rankingService.getAverageByProductId(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}