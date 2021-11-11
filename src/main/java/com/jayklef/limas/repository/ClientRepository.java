package com.jayklef.limas.repository;

import com.jayklef.limas.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findClientByFirstName(String firstName);

    public Client findClientByLastName(String lastName);

    public Client findClientByPhoneNumber(String phoneNumber);
}
