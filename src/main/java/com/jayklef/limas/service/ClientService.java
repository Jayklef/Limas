package com.jayklef.limas.service;

import com.jayklef.limas.exception.ClientNotFoundException;
import com.jayklef.limas.model.Client;

import java.util.List;

public interface ClientService {
    Client saveClient(Client client);

    List<Client> getAllClients();

    List<Client> getAllClientsByMembershipCategory(String mcName);

    Client getClientById(Long clientId) throws ClientNotFoundException;

    Client updateClient(Long clientId, Client client);

    void deleteClient();

    Client getClientByFirstName(String firstName) throws ClientNotFoundException;

    Client getClientBylastName(String lastName) throws ClientNotFoundException;

    Client getClientByPhoneNumber(String phoneNumber) throws ClientNotFoundException;
}
