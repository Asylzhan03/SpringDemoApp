package com.example.SpringDemoApp.service.implementation;

import com.example.SpringDemoApp.entity.Client;
import com.example.SpringDemoApp.repository.ClientRepository;
import com.example.SpringDemoApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImplementation implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.getOne(id);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Long id, Client client) {
        Optional<Client> entity = clientRepository.findById(id);
        if(entity.isPresent()) {
            Client client1 = entity.get();
            client1.setId(client.getId());
            client1.setName(client.getName());
            client1.setSurname(client.getSurname());
            client1.setAddress(client.getAddress());
            return clientRepository.save(client1);
        }
        return null;
    }

    @Override
    public void deleteClientAll() {
        clientRepository.deleteAll();
    }
}
