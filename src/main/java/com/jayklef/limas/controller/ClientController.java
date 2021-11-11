package com.jayklef.limas.controller;

import com.jayklef.limas.exception.ClientNotFoundException;
import com.jayklef.limas.model.Client;
import com.jayklef.limas.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class ClientController {

    private ClientService clientService;

    private Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/clients")
    public Client saveClient(@Valid @RequestBody Client client){
        logger.info("Inside saveClient of ClientController");
        return clientService.saveClient(client);
    }

    @GetMapping("/clients")
    public List<Client> getAllClients(){
        logger.info("Inside getAllClients of ClientController");
        return clientService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable("clientId") Long clientId) throws ClientNotFoundException {
        return clientService.getClientById(clientId);
    }

    @GetMapping("/clients/{firstName}")
    public Client getClientByFirstName(@PathVariable("firstName") String firstName) throws ClientNotFoundException {
        return clientService.getClientByFirstName(firstName);
    }

    @GetMapping("/clients/{lastName}")
    public Client getClientBylastName(@PathVariable("lastName") String lastName) throws ClientNotFoundException {
        return clientService.getClientBylastName(lastName);
    }

    @GetMapping("/clients/{phonenumber}")
    public Client getClientByPhoneNumber(@PathVariable("phonenumber") String phoneNumber) throws ClientNotFoundException {
        return clientService.getClientByPhoneNumber(phoneNumber);
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable("clientId") Long clientId, Client client){
        return clientService.updateClient(clientId, client);
    }

    @DeleteMapping("/clients/{id}")
    public String deleteClient(@PathVariable("clientId") Long clientId){
        clientService.deleteClient();
        return "Client removed successfully";
    }
}
