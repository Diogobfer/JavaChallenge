/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaChallenge.rest.CalculatorApi;

import com.JavaChallenge.rest.InputValidator.InputValidator;
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
    
    public CalculatorApi(InputValidator inputValidator)
    {
        this.inputValidator = inputValidator;
    }
    
    @Override
    @GetMapping("/sum")
    public String sum(@RequestParam String a ,@RequestParam String b)
    {
        inputValidator.checkInput(a);
        inputValidator.checkInput(b);
        return String.format("sum result: %s", a);
    }
    
    @Override
    @GetMapping("/subtraction")
    public String subtraction( @RequestParam String a , @RequestParam  String b)
    {
        inputValidator.checkInput(a);
        inputValidator.checkInput(b);
        return "a"+"b";
    }
    
    @Override
    @GetMapping("/multiplication")
    public String multiplication( @RequestParam String a ,@RequestParam  String b)
    {
        inputValidator.checkInput(a);
        inputValidator.checkInput(b);
        return "a"+"b";
    }
    
    @Override
    @GetMapping("/division")
    public String division( @RequestParam   String a , @RequestParam String b)
    {
        inputValidator.checkInput(a);
        inputValidator.checkInput(b);
        return "a"+"b";
    }
    
   
    @GetMapping("/")
    public String teste()
    {
        return String.format("sum result: %s", "Iam the restModule");
    }
}
