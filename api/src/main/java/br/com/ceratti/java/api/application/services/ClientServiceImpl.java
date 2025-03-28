package br.com.ceratti.java.api.application.services;

import java.util.List;
import java.util.regex.Pattern;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ceratti.java.api.domain.models.Client;
import br.com.ceratti.java.api.domain.repositories.ClientRepository;
import br.com.ceratti.java.api.domain.services.ClientService;
import br.com.ceratti.java.api.presentation.request.ClientRequestDTO;
import br.com.ceratti.java.api.presentation.response.ClientResponseDTO;

@Service
public class ClientServiceImpl implements ClientService {


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<ClientResponseDTO> findAll() {

        List<Client> clients = (List<Client>) clientRepository.findAll();

        return clients.stream()
            .map(client -> modelMapper.map(client, ClientResponseDTO.class))
            .toList();
    }


    @Override
    public ClientResponseDTO create(ClientRequestDTO clientRequestDTO) {
        try {
            if (clientRequestDTO.getName() == null || clientRequestDTO.getName().trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be blank");
            }
    
            if (clientRequestDTO.getEmail() == null || !isValidEmail(clientRequestDTO.getEmail())) {
                throw new IllegalArgumentException("Email must be a valid email address");
            }
            
            Client client = clientRepository.findByEmail(clientRequestDTO.getEmail());
            
            if (client != null) {
                throw new IllegalArgumentException("Email already exists");
            }
    


            Client clientEntity = modelMapper.map(clientRequestDTO, Client.class);
            Client savedClient = clientRepository.save(clientEntity);
            ClientResponseDTO clientResponseDTO = modelMapper.map(savedClient, ClientResponseDTO.class);

            return clientResponseDTO;

        } catch (Exception e) {
            throw new RuntimeException("Error creating client", e);
        }
    
    }






    
    
    @Override
    public ClientResponseDTO findByName(String name) {
        Client client = clientRepository.findByName(name);
        if (client != null) 
            return modelMapper.map(client, ClientResponseDTO.class);
            
        throw new IllegalArgumentException("Client not found");
    }
    










    
    static private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        java.util.regex.Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
