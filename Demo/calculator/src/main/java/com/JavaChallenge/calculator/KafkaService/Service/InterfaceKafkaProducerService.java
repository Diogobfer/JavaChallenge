/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JavaChallenge.calculator.KafkaService.Service;

/**
 *
 * @author Administrator
 */
public interface InterfaceKafkaProducerService {
    
    public void sumResult(String message);

    public void subtractionResult(String message);

    public void multiplicationResult(String message);

    public void divisionResult(String message);
}
