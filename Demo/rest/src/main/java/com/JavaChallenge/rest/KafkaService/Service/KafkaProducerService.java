/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaChallenge.rest.KafkaService.Service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
/**
 *
 * @author Administrator
 */
@Service
public class KafkaProducerService implements InterfaceKafkaProducerService{
    public static final String REQUEST_SUM = "requestSum";
    public static final String REQUEST_SUBTRACTION = "requestSubtraction";
    public static final String REQUEST_MULTIPLICATION = "requestMultiplication";
    public static final String REQUEST_DIVISION = "requestDivision";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void resquestSum(String message) {
        kafkaTemplate.send(REQUEST_SUM, message);
        System.out.println("Message sent: " + message);
    }
     @Override
    public void resquestSubtraction(String message) {
        kafkaTemplate.send(REQUEST_SUBTRACTION, message);
        System.out.println("Message sent: " + message);
    }
     @Override
     public void resquestMultiplication(String message) {
        kafkaTemplate.send(REQUEST_MULTIPLICATION, message);
        System.out.println("Message sent: " + message);
    }
     @Override
     public void resquestDivision(String message) {
        kafkaTemplate.send(REQUEST_DIVISION, message);
        System.out.println("Message sent: " + message);
    }
    
    
}
