package ar.edu.unrn.rankingservice.service;

import ar.edu.unrn.rankingservice.dto.ClientDTO;

public interface ClientService {

    void updateName(ClientDTO clientDTO);

    ClientDTO findClientById(Long id);
}
