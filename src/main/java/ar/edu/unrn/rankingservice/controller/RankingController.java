package ar.edu.unrn.rankingservice.controller;

import ar.edu.unrn.rankingservice.dto.RankingDTO;
import ar.edu.unrn.rankingservice.service.RankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "/rankings")
public class RankingController {

    @Autowired
    RankingService rankingService;


    @PostMapping()
    public ResponseEntity createRanking(@RequestBody RankingDTO rankingDTO) {
        try {
            RankingDTO result = rankingService.create(rankingDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getRankingsByProductId(@PathVariable Long id, Pageable pageable) {
        try {
            return ResponseEntity.ok().body(rankingService.getRankingsByProductId(id,pageable));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/average/product/{id}")
    public ResponseEntity getAverageByProductId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(rankingService.getAverageByProductId(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
