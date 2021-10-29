/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.Reto3.service;

import com.Reto3.Reto3.model.Client;
import com.Reto3.Reto3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agude
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }
        else{
        Optional<Client> paux=clientRepository.getClient(client.getIdClient());
        if(paux.isEmpty()){
            return clientRepository.save(client);
        }
        else{
            return client;
        }
        }
    }
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client>guardar=clientRepository.getClient(client.getIdClient());
            if(!guardar.isEmpty()){
                if(client.getName()!=null){
                    guardar.get().setName(client.getName());                 
                }
                if(client.getAge()!=null){
                    guardar.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    guardar.get().setPassword(client.getPassword());
                }                
                return clientRepository.save(guardar.get());
            }
        }
        return client;
    }
        
    public boolean delete(int id){
        Optional<Client> client=getClient(id);
        if(!client.isEmpty()){
            clientRepository.delete(client.get());
            return true;
        }
        return false;
    }    
}
