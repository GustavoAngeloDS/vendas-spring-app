package br.com.vendas.services;

import br.com.vendas.models.Client;
import br.com.vendas.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client save(Client client) {
        Optional<Client> optClient = clientRepository.findClientByCpf(client.getCpf(), 0);

        if (!optClient.isPresent()) {
            return clientRepository.save(client);
        }
        return new Client();
    }

    public Client update(Client client) {
        Optional<Client> optClient = clientRepository.findById(client.getId());
        Client clientUpdate = new Client();

        if (optClient.isPresent() &&
            !clientRepository.findClientByCpf(client.getCpf(), client.getId()).isPresent()) {
            clientUpdate = clientRepository.save(client);
        }

        return clientUpdate;
    }

    public void remove(Client client) {
        Optional<Client> optClient = clientRepository.findById(client.getId());

        if (optClient.isPresent()) {
            clientRepository.delete(client);
        }
    }
}
