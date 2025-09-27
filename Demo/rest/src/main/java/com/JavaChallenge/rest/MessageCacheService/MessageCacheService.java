/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaChallenge.rest.MessageCacheService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class MessageCacheService implements InterfaceMessageCacheService {

    private final String PLACEHOLDER = "\\|";
    
    
    private final ConcurrentHashMap<String, String> messageCache = new ConcurrentHashMap<>();  
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
     
    
    @Override
    public void storeMessage(String msg) {
        String[] IDAndResult = splitIDFromResult(msg);
        String ID = IDAndResult[0].replace("\"", "").trim();
        String result = IDAndResult[1].replace("\"", "");
        System.out.println("I receved this mesage from calculator store on hashmap");
        System.out.println("ID :"+ID);
        System.out.println("number :"+result);
        messageCache.put(ID, result);
    }
    
    
    @Override 
    public CompletableFuture<String> checkMessage(String ID)
    {   
        System.out.println("Id to check for : "+ ID.trim());
       
         CompletableFuture<String> result = new CompletableFuture<>();
         scheduler.scheduleAtFixedRate(() -> {
            String value = messageCache.get(ID);
            if (value != null) {
                result.complete(value);
                messageCache.remove(ID);
                throw new RuntimeException("Done"); 
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
        result.whenComplete((v, ex) -> result.cancel(true));
        return result;
        
    }
     private String[] splitIDFromResult(String msg)
    {
        return msg.split(PLACEHOLDER);
        
    } 
}
