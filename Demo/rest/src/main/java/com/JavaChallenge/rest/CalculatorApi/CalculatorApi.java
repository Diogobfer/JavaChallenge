/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaChallenge.rest.CalculatorApi;

import com.JavaChallenge.rest.InputValidator.InputValidator;
import com.JavaChallenge.rest.KafkaService.Service.KafkaProducerService;
import com.JavaChallenge.rest.MessageCacheService.MessageCacheService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Administrator
 */
@Service
@RestController
public class CalculatorApi implements InterfaceCalculatorApi
{
    private final InputValidator inputValidator; 
    private final MessageCacheService messageCacheService;
    private final KafkaProducerService kafkaProducerService;
    private static final String PLACEHOLDER = "|"; 
    public CalculatorApi(InputValidator inputValidator,MessageCacheService messageCacheService,KafkaProducerService kafkaProducerService)
    {
        this.inputValidator = inputValidator;
        this.messageCacheService = messageCacheService;
        this.kafkaProducerService = kafkaProducerService;
    }    
    
    @Override
    @Async
    @GetMapping("/sum")
    public CompletableFuture<ResponseEntity<String>> sum(@RequestParam String a ,@RequestParam String b)
    {
        //create a idetifier for the request 
        String operationIdentifier = UUID.randomUUID().toString(); 
        //check if the input is a number 
        if(inputValidator.checkInput(a)&& inputValidator.checkInput(b))
        {
           //publis the ID , fist number and second number via kafka using place holder 
            kafkaProducerService.resquestSum(String.format("%S%s%s%s%s",operationIdentifier,PLACEHOLDER,a,PLACEHOLDER,b));
            
            System.out.println(String.format("%S%s%s%s%s",operationIdentifier ,PLACEHOLDER,a,PLACEHOLDER,b));
                 
        }else{
            String errorMessage = "Error: Invalid input. Both parameters must be valid numbers.";
        
        
            return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(errorMessage)) ;
        }
            //return the message with the same id when it arives 
          return messageCacheService.checkMessage(operationIdentifier.toUpperCase()).thenApply(value -> ResponseEntity.ok(value)).exceptionally(ex -> ResponseEntity.status(500).body("Error:"));
        
        
    }
    
    @Override
    @Async
    @GetMapping("/subtraction")
    public CompletableFuture<ResponseEntity<String>> subtraction( @RequestParam String a , @RequestParam  String b)
    {
        //create a idetifier for the request 
        String operationIdentifier = UUID.randomUUID().toString(); 
        if(inputValidator.checkInput(a)&& inputValidator.checkInput(b))
        {
           
            kafkaProducerService.resquestSubtraction(String.format("%S%s%s%s%s",operationIdentifier,PLACEHOLDER,a,PLACEHOLDER,b));
            
            System.out.println(String.format("%S%s%s%s%s",operationIdentifier ,PLACEHOLDER,a,PLACEHOLDER,b));
                 
        }else{
            String errorMessage = "Error: Invalid input. Both parameters must be valid numbers.";
        
        
            return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(errorMessage)) ;
        }
        
          return messageCacheService.checkMessage(operationIdentifier.toUpperCase()).thenApply(value -> ResponseEntity.ok(value)).exceptionally(ex -> ResponseEntity.status(500).body("Error:"));
    }
    
    @Override
    @Async
    @GetMapping("/multiplication")
    public CompletableFuture<ResponseEntity<String>> multiplication( @RequestParam String a ,@RequestParam  String b)
    {
        //create a idetifier for the request 
        String operationIdentifier = UUID.randomUUID().toString(); 
        if(inputValidator.checkInput(a)&& inputValidator.checkInput(b))
        {
           
            kafkaProducerService.resquestMultiplication(String.format("%S%s%s%s%s",operationIdentifier,PLACEHOLDER,a,PLACEHOLDER,b));
            
            System.out.println(String.format("%S%s%s%s%s",operationIdentifier ,PLACEHOLDER,a,PLACEHOLDER,b));
                 
        }else{
            String errorMessage = "Error: Invalid input. Both parameters must be valid numbers.";
        
        
            return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(errorMessage)) ;
        }
        
          return messageCacheService.checkMessage(operationIdentifier.toUpperCase()).thenApply(value -> ResponseEntity.ok(value)).exceptionally(ex -> ResponseEntity.status(500).body("Error:"));
    }
    
    @Override
    @Async
    @GetMapping("/division")
    public CompletableFuture<ResponseEntity<String>> division( @RequestParam   String a , @RequestParam String b)
    {
        //create a idetifier for the request 
        String operationIdentifier = UUID.randomUUID().toString(); 
        if(inputValidator.checkInput(a)&& inputValidator.checkInput(b))
        {
           
            kafkaProducerService.resquestDivision(String.format("%S%s%s%s%s",operationIdentifier,PLACEHOLDER,a,PLACEHOLDER,b));
            
            System.out.println(String.format("%S%s%s%s%s",operationIdentifier ,PLACEHOLDER,a,PLACEHOLDER,b));
                 
        }else
        {
            String errorMessage = "Error: Invalid input. Both parameters must be valid numbers.";
        
        
            return CompletableFuture.completedFuture(ResponseEntity.badRequest().body(errorMessage)) ;
        }
        
          return messageCacheService.checkMessage(operationIdentifier.toUpperCase()).thenApply(value -> ResponseEntity.ok(value)).exceptionally(ex -> ResponseEntity.status(500).body("Error:"));
    }
    
    @Async
    @GetMapping("/")
    public String teste()
    {
        return String.format("Java challenge-Rest Module");
    }
}
