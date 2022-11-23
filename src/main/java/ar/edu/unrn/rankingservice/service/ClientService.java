package ar.edu.unrn.rankingservice.service;

import ar.edu.unrn.rankingservice.dto.ClientDTO;
import ar.edu.unrn.rankingservice.model.Client;
import ar.edu.unrn.userservice.dto.ClientMessage;

public interface ClientService {

    void updateName(ClientDTO clientDTO);

    Client findClientById(Long id);
}
