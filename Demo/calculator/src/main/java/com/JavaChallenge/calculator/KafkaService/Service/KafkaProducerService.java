/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaChallenge.calculator.KafkaService.Service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
/**
 *
 * @author Administrator
 */
@Service
public class KafkaProducerService implements InterfaceKafkaProducerService{
    private static final String SUM_RESULT = "sumResult";
    private static final String SUBTRACTION_RESULT = "subtractionResult";
    private static final String MULTIPLICATION_RESULT = "multiplicationResult";
    private static final String DIVISION_RESULT = "divisionResult";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

   
    @Override
    public void sumResult(String message) {
        kafkaTemplate.send(SUM_RESULT, message);
        System.out.println("Message sent: " + message);
    }

    @Override
    public void subtractionResult(String message) {
         kafkaTemplate.send(SUBTRACTION_RESULT, message);
        System.out.println("Message sent: " + message);
    }

    @Override
    public void multiplicationResult(String message) {
        kafkaTemplate.send(MULTIPLICATION_RESULT, message);
        System.out.println("Message sent: " + message);
    }

    @Override
    public void divisionResult(String message) {
         kafkaTemplate.send(DIVISION_RESULT, message);
        System.out.println("Message sent: " + message);
    }
}
