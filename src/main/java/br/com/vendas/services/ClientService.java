package br.com.vendas.services;

import br.com.vendas.models.Client;
import br.com.vendas.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findClientByText(String text){
        return clientRepository.findClientByText(text);
    }
}
