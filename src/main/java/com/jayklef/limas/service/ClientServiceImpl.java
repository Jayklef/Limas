package com.jayklef.limas.service;

import com.jayklef.limas.exception.ClientNotFoundException;
import com.jayklef.limas.model.Client;
import com.jayklef.limas.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long clientId) throws ClientNotFoundException {
        Optional<Client> client = clientRepository.findById(clientId);

        if (!client.isPresent()){
            throw new ClientNotFoundException();
        }
        return client.get();
    }

    @Override
    public Client getClientByFirstName(String firstName) throws ClientNotFoundException {
        Optional<Client> client = Optional.ofNullable(clientRepository.findClientByFirstName(firstName));

        if (client.isPresent()){
            return client.get();
        }
        throw new ClientNotFoundException();
    }

    @Override
    public Client getClientBylastName(String lastName) throws ClientNotFoundException {
        Optional<Client> client = Optional.ofNullable(clientRepository.findClientByLastName(lastName));

        if (client.isPresent()){
            return client.get();
        }
        throw new ClientNotFoundException();
    }

    @Override
    public Client getClientByPhoneNumber(String phoneNumber) throws ClientNotFoundException {
        Optional<Client> client = Optional.ofNullable(clientRepository.findClientByPhoneNumber(phoneNumber));

        if (!client.isPresent()){
            throw new ClientNotFoundException();
        }
        return client.get();
    }

    @Override
    public Client updateClient(Long clientId, Client client) {
        return null;
    }

    @Override
    public void deleteClient() {
    }

}
