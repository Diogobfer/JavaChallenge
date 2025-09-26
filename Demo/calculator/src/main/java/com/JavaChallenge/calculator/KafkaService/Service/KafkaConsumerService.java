/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaChallenge.calculator.KafkaService.Service;
import com.JavaChallenge.calculator.CalculationService.CalculationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
/**
 *
 * @author Administrator
 */
@Service
public class KafkaConsumerService implements InterfaceKafkaConsumerService {
    private static final String PLACEHOLDER = "$";
    
    private final CalculationService calculationService;
    private final KafkaProducerService kafkaProducerService;
   //the calculus will all be done hear evry time that the kafka recebe the numbers it do the cauculus 
    
    public KafkaConsumerService(CalculationService calculationService, KafkaProducerService kafkaProducerService)
    {
        this.calculationService = calculationService;
        this.kafkaProducerService = kafkaProducerService;
    }
    
    @KafkaListener(topics = "requestSum", groupId = "com.JavaChallenge")
    @Override
    public void requestSum(String message) {
       String[] splitedNumbers = splitNunbersFromMsg(message);
       kafkaProducerService.sumResult(calculationService.sum(splitedNumbers[0], splitedNumbers[1]));
    }
    
    @KafkaListener(topics = "requestSubtraction", groupId = "com.JavaChallenge")
    @Override
    public void requestSubtraction(String message) {
       String[] splitedNumbers = splitNunbersFromMsg(message);
       kafkaProducerService.subtractionResult(calculationService.subtraction(splitedNumbers[0], splitedNumbers[1]));
    }
    @KafkaListener(topics = "requestMultiplication", groupId = "com.JavaChallenge")
    @Override
    public void requestMultiplication(String message) {
       String[] splitedNumbers = splitNunbersFromMsg(message);
       kafkaProducerService.multiplicationResult(calculationService.multiplication(splitedNumbers[0], splitedNumbers[1]));
    }
    
    @KafkaListener(topics = "requestDivision", groupId = "com.JavaChallenge")
    @Override
    public void requestDivision(String message) {
        String[] splitedNumbers = splitNunbersFromMsg(message);
        kafkaProducerService.divisionResult(calculationService.division(splitedNumbers[0], splitedNumbers[1]));
    }
    
    private String[] splitNunbersFromMsg(String msg)
    {
        return msg.split(PLACEHOLDER);
        
    }
}
