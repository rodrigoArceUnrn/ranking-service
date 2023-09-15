package ar.edu.unrn.rankingservice.controller;

import ar.edu.unrn.rankingservice.dto.ClientDTO;
import ar.edu.unrn.rankingservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService clientService;


    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getRankingsByProductId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(clientService.findClientById(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
