package br.com.vendas.controllers;

import br.com.vendas.dtos.ClientDto;
import br.com.vendas.models.Client;
import br.com.vendas.services.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ClientDto clientDto) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDto, client);

        return new ResponseEntity<>(clientService.save(client), HttpStatus.OK);
    }

    @GetMapping("/search/{text}")
    public List<Client> findById(@PathVariable(value="text") String text){
        return clientService.findClientByText(text);
    }
}
