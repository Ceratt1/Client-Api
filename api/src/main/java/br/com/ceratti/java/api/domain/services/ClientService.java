package br.com.ceratti.java.api.domain.services;

import java.util.List;

import br.com.ceratti.java.api.presentation.request.ClientRequestDTO;
import br.com.ceratti.java.api.presentation.response.ClientResponseDTO;

public interface ClientService {

    List<ClientResponseDTO> findAll();
    ClientResponseDTO create(ClientRequestDTO client);
    ClientResponseDTO findByName(String name);




}
