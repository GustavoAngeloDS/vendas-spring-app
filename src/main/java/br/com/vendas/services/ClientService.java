package br.com.vendas.services;

import br.com.vendas.models.Client;
import br.com.vendas.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public ResponseEntity<?> save(Client client) {
        Client clientEntity = clientRepository.save(client);
        return new ResponseEntity<>(clientEntity, HttpStatus.OK);
    }
}
