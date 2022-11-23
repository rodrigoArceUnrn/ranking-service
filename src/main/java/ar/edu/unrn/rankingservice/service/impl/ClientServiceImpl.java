package ar.edu.unrn.rankingservice.service.impl;

import ar.edu.unrn.rankingservice.dto.ClientDTO;
import ar.edu.unrn.rankingservice.model.Client;
import ar.edu.unrn.rankingservice.repository.ClientRepository;
import ar.edu.unrn.rankingservice.service.ClientService;
import ar.edu.unrn.userservice.dto.ClientMessage;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    final
    ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void updateName(ClientDTO clientDTO) {
        Client client = clientRepository.findClientById(clientDTO.getId());
        client.setName(clientDTO.getName());
        clientRepository.save(client);

    }

    @Override
    public Client findClientById(Long id) {
        return clientRepository.findClientById(id);
    }


}
