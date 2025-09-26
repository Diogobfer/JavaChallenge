/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaChallenge.rest.CalculatorApi;

import com.JavaChallenge.rest.InputValidator.InputValidator;
import com.JavaChallenge.rest.KafkaService.Service.KafkaConsumerService;
import com.JavaChallenge.rest.KafkaService.Service.KafkaProducerService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@Service
@RestController
public class CalculatorApi implements InterfaceCalculatorApi
{
    private final InputValidator inputValidator; 
    private final KafkaConsumerService kafkaConsumerService;
    private final KafkaProducerService kafkaProducerService;
    private static final String PLACEHOLDER = "$"; 
    public CalculatorApi(InputValidator inputValidator,KafkaConsumerService kafkaConsumerService,KafkaProducerService kafkaProducerService)
    {
        this.inputValidator = inputValidator;
        this.kafkaConsumerService = kafkaConsumerService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Override
    @GetMapping("/sum")
    
    public String sum(@RequestParam String a ,@RequestParam String b)
    {
        if(inputValidator.checkInput(a)&& inputValidator.checkInput(b))
        {
            kafkaProducerService.resquestSum(String.format("%s%s%s", a,PLACEHOLDER,b));
            return String.format("The result of the Sum is : %s",kafkaConsumerService.getSumResult());
        }
        
        return String.format("Not a valid input");
    }
    
    @Override
    @GetMapping("/subtraction")
    public String subtraction( @RequestParam String a , @RequestParam  String b)
    {
        if(inputValidator.checkInput(a)&& inputValidator.checkInput(b))
        {
            kafkaProducerService.resquestSubtraction(String.format("%s%s%s", a,PLACEHOLDER,b));
            return String.format("The result of the Sum is : %s",kafkaConsumerService.getSumResult());
        }
        
        return String.format("Not a valid input");
    }
    
    @Override
    @GetMapping("/multiplication")
    public String multiplication( @RequestParam String a ,@RequestParam  String b)
    {
        if(inputValidator.checkInput(a)&& inputValidator.checkInput(b))
        {
            kafkaProducerService.resquestMultiplication(String.format("%s%s%s", a,PLACEHOLDER,b));
            return String.format("The result of the Sum is : %s",kafkaConsumerService.getSumResult());
        }
        
        return String.format("Not a valid input");
    }
    
    @Override
    @GetMapping("/division")
    public String division( @RequestParam   String a , @RequestParam String b)
    {
        if(inputValidator.checkInput(a)&& inputValidator.checkInput(b))
        {
            kafkaProducerService.resquestDivision(String.format("%s%s%s", a,PLACEHOLDER,b));
            return String.format("The result of the Sum is : %s",kafkaConsumerService.getSumResult());
        }
        
        return String.format("Not a valid input");
    }
    
   
    @GetMapping("/")
    public String teste()
    {
        return String.format("Java challenge-Rest Module");
    }
}
