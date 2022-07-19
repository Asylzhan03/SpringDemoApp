package com.example.SpringDemoApp.service;

import com.example.SpringDemoApp.entity.Client;

import java.util.List;

public interface ClientService {
    Client addClient(Client client);
    List<Client> getAllClient();
    Client getClient(Long id);
    void deleteClient(Long id);
    Client updateClient(Long id, Client client);
    void deleteClientAll();
}
