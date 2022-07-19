package com.example.SpringDemoApp.controller;

import com.example.SpringDemoApp.entity.Client;
import com.example.SpringDemoApp.entity.Staff;
import com.example.SpringDemoApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Client>> readClient() {
        List<Client> clientList = clientService.getAllClient();
        if(clientList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping(value = "/addClient")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        try {
            clientService.addClient(client);
            return new ResponseEntity<>(client, HttpStatus.CREATED);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/updateClient")
    public ResponseEntity<HttpStatus> updateClient(@RequestParam Long id,
                               @RequestBody Client client) {
        try {
            Client updatedClient = clientService.updateClient(id, client);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/deleteClient/{id}")
    public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") Long id) {
        try  {
            clientService.deleteClient(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value="/deleteClient")
    public ResponseEntity<HttpStatus> deleteClientAll() {
        try {
            clientService.deleteClientAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
