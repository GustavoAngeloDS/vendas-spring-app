package br.com.vendas.controllers;

import br.com.vendas.dtos.ClientDto;
import br.com.vendas.models.Client;
import br.com.vendas.responses.ErrorResponse;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> save(@RequestBody @Valid ClientDto clientDto) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDto, client);

        Client clientSave = clientService.save(client);

        if (clientSave.getId() != null) {
            return new ResponseEntity<>(clientSave, HttpStatus.OK);
        }

        return new ResponseEntity<>(ErrorResponse.builder().message("Já existe um cliente com este CPF.").build(), HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.update(client), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Client client) {
        String returnMessage = clientService.remove(client);

        if (returnMessage.equals(""))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(ErrorResponse.builder().message(returnMessage).build(), HttpStatus.NOT_ACCEPTABLE);
    }
}