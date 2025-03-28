package br.com.ceratti.java.api.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ceratti.java.api.domain.models.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    public Client findByEmail(String email);

    public Client findByName(String name);
    
} 