package ar.edu.unrn.rankingservice.repository;

import ar.edu.unrn.rankingservice.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientById(Long id);
}