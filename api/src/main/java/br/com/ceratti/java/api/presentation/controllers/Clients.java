package br.com.ceratti.java.api.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ceratti.java.api.domain.services.ClientService;
import br.com.ceratti.java.api.presentation.request.ClientRequestDTO;
import br.com.ceratti.java.api.presentation.response.ClientResponseDTO;

@RestController()
@RequestMapping("/clients")
public class Clients {

    @Autowired
    private final ClientService clientService;


    public Clients(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public List<ClientResponseDTO> getClients() {
        return clientService.findAll();
    }

    @PostMapping()
    public ClientResponseDTO createClient(@RequestBody ClientRequestDTO client) {
        return clientService.create(client);
    }

    @GetMapping("/{name}")
    public ClientResponseDTO getClientByEmail(@PathVariable String name) {
        return clientService.findByName(name);
    };

    


    
}
