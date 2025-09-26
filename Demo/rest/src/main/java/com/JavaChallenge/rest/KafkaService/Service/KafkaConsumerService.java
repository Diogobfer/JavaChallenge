/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaChallenge.rest.KafkaService.Service;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
/**
 *
 * @author Administrator
 */
@Service
public class KafkaConsumerService implements InterfaceKafkaConsumerService{
    
    private String sumResult;
    private String subtractionResult;
    private String multiplicationResult;
    private String divisionResult;

    
    @KafkaListener(topics = "sumResult", groupId = "com.JavaChallenge")
    @Override
    public void sumResult(String message) {
        
        this.sumResult = message;
    }

    @KafkaListener(topics = "subtractionResult", groupId = "com.JavaChallenge")
    @Override
    public void subtractionResult(String message) {
        
       this.subtractionResult= message;
    }

    @KafkaListener(topics = "multiplicationResult", groupId = "com.JavaChallenge")
    @Override
    public void multiplicationResult(String message) {
       this.multiplicationResult = message;
    }

    @KafkaListener(topics = "divisionResult", groupId = "com.JavaChallenge")
    @Override
    public void divisionResult(String message) {
      this.divisionResult = message;
    }
   
    public String getSumResult() {
        return sumResult;
    }

   
    public String getSubtractionResult() {
        return subtractionResult;
    }

    
    public String getMultiplicationResult() {
        return multiplicationResult;
    }

   
    public String getDivisionResult() {
        return divisionResult;
    }
}
