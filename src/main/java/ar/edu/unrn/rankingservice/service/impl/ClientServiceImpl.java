package ar.edu.unrn.rankingservice.service.impl;

import ar.edu.unrn.rankingservice.dto.ClientDTO;
import ar.edu.unrn.rankingservice.model.Client;
import ar.edu.unrn.rankingservice.repository.ClientRepository;
import ar.edu.unrn.rankingservice.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    final
    ClientRepository clientRepository;

    final ModelMapper modelMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void updateName(ClientDTO clientDTO) {
        Client client = clientRepository.findClientById(clientDTO.getId());
        client.setName(clientDTO.getName());
        clientRepository.save(client);

    }
}
