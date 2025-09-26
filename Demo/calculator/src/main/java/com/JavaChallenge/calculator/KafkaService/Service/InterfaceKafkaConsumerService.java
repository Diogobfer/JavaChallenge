/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JavaChallenge.calculator.KafkaService.Service;

/**
 *
 * @author Administrator
 */
public interface InterfaceKafkaConsumerService {
    
    public void requestSum(String message);

    public void requestSubtraction(String message);

    public void requestMultiplication(String message);

    public void requestDivision(String message);
}
