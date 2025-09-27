/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaChallenge.calculator.KafkaService.Service;
import com.JavaChallenge.calculator.CalculationService.CalculationService;
import java.util.Arrays;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
/**
 *
 * @author Administrator
 */
@Service
public class KafkaConsumerService implements InterfaceKafkaConsumerService {
    private static final String PLACEHOLDERSPLIT = "\\|";
    private static final String PLACEHOLDERJOIN = "|";
    
    private final CalculationService calculationService;
    private final KafkaProducerService kafkaProducerService;
    
    public KafkaConsumerService(CalculationService calculationService, KafkaProducerService kafkaProducerService)
    {
        this.calculationService = calculationService;
        this.kafkaProducerService = kafkaProducerService;
    }
    //Every time the module receives a value on this topic, the calculation is performed, and then the ID and result of the request are published on the respective topic
    @KafkaListener(topics = "requestSum", groupId = "com.JavaChallenge")
    @Override
    public void requestSum(String message) {
       String[] splitedNumbers = splitNunbersFromMsg(message);
        System.out.println("Request Sum ");
        System.out.println("ID : "+ splitedNumbers[0]);
        System.out.println("NUM1 : "+ splitedNumbers[1]);
        System.out.println("NUM2 : "+ splitedNumbers[2]);
       kafkaProducerService.sumResult(String.format("%s%s%s",splitedNumbers[0],PLACEHOLDERJOIN,calculationService.sum(splitedNumbers[1], splitedNumbers[2])));
    }
    
    @KafkaListener(topics = "requestSubtraction", groupId = "com.JavaChallenge")
    @Override
    public void requestSubtraction(String message) {
       String[] splitedNumbers = splitNunbersFromMsg(message);
        System.out.println("Request Subtraction ");
        System.out.println("ID : "+ splitedNumbers[0]);
        System.out.println("NUM1 : "+ splitedNumbers[1]);
        System.out.println("NUM2 : "+ splitedNumbers[2]);
       kafkaProducerService.subtractionResult(String.format("%s%s%s",splitedNumbers[0],PLACEHOLDERJOIN,calculationService.subtraction(splitedNumbers[1], splitedNumbers[2])));
    }
    @KafkaListener(topics = "requestMultiplication", groupId = "com.JavaChallenge")
    @Override
    public void requestMultiplication(String message) {
       String[] splitedNumbers = splitNunbersFromMsg(message);
        System.out.println("Request Multiplication ");
        System.out.println("ID : "+ splitedNumbers[0]);
        System.out.println("NUM1 : "+ splitedNumbers[1]);
        System.out.println("NUM2 : "+ splitedNumbers[2]);
       kafkaProducerService.multiplicationResult(String.format("%s%s%s",splitedNumbers[0],PLACEHOLDERJOIN,calculationService.multiplication(splitedNumbers[1], splitedNumbers[2])));
    }
    
    @KafkaListener(topics = "requestDivision", groupId = "com.JavaChallenge")
    @Override
    public void requestDivision(String message) {
         String[] splitedNumbers = splitNunbersFromMsg(message);
        System.out.println("Request Division ");
        System.out.println("ID : "+ splitedNumbers[0]);
        System.out.println("NUM1 : "+ splitedNumbers[1]);
        System.out.println("NUM2 : "+ splitedNumbers[2]);
       kafkaProducerService.divisionResult(String.format("%s%s%s",splitedNumbers[0],PLACEHOLDERJOIN,calculationService.division(splitedNumbers[1], splitedNumbers[2])));
    }
    
    private String[] splitNunbersFromMsg(String msg)
    {
        String[] msgInfo = msg.split(PLACEHOLDERSPLIT); 
        return  Arrays.stream(msgInfo).map(s -> s.replace("\"", "")).toArray(String[]::new);
         
    }
}
