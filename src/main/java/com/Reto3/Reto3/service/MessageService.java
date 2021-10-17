/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.Reto3.service;

import com.Reto3.Reto3.model.Message;
import com.Reto3.Reto3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agude
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }
        else{
        Optional<Message> paux=messageRepository.getMessage(message.getIdMessage());
        if(paux.isEmpty()){
            return messageRepository.save(message);
        }
        else{
            return message;
        }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message>guardar=messageRepository.getMessage(message.getIdMessage());
            if(!guardar.isEmpty()){
                if(message.getMessageText()!=null){
                    guardar.get().setMessageText(message.getMessageText());
                 
                }
                return messageRepository.save(guardar.get());
            }
        }
        return message;
    }
        
    public boolean delete(int id){
        Optional<Message> client=getMessage(id);
        if(!client.isEmpty()){
            messageRepository.delete(client.get());
            return true;
        }
        return false;
    }    
}
