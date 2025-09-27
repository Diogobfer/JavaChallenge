/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaChallenge.rest.KafkaService.Service;
import com.JavaChallenge.rest.MessageCacheService.MessageCacheService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
/**
 *
 * @author Administrator
 */
@Service
public class KafkaConsumerService implements InterfaceKafkaConsumerService{
    
    private final MessageCacheService messageCacheService;
    
    public KafkaConsumerService(MessageCacheService messageCacheService )
    {
        this.messageCacheService = messageCacheService;
    }
    
    
    //when the mesage is recebed by de module is stored on the hashmap by ID 
    @KafkaListener(topics = "sumResult", groupId = "com.JavaChallenge")
    @Override
    public void sumResult(String message) {
        
        System.out.println("mesage recived from calculator : "+ message);
        messageCacheService.storeMessage(message); 
    }

    @KafkaListener(topics = "subtractionResult", groupId = "com.JavaChallenge")
    @Override
    public void subtractionResult(String message) {
        
       messageCacheService.storeMessage(message); 
    }

    @KafkaListener(topics = "multiplicationResult", groupId = "com.JavaChallenge")
    @Override
    public void multiplicationResult(String message) {
       messageCacheService.storeMessage(message); 
    }

    @KafkaListener(topics = "divisionResult", groupId = "com.JavaChallenge")
    @Override
    public void divisionResult(String message) {
      messageCacheService.storeMessage(message); 
    }
   
}
