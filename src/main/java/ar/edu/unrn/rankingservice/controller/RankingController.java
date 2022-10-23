package ar.edu.unrn.rankingservice.controller;

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


    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) {
//        try {
            return ResponseEntity.ok().body("rankingService.getProductById(id)");
//        } catch (RankingUnknownException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
    }

    @GetMapping()
    public ResponseEntity getProducts(@PageableDefault Pageable pageable) {
        try {
            return ResponseEntity.ok().body("rankingService.getProducts(pageable)");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
