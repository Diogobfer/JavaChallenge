/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JavaChallenge.rest.CalculatorApi;

import java.util.concurrent.CompletableFuture;
import org.springframework.http.ResponseEntity;


/**
 *
 * @author Administrator
 */
public interface InterfaceCalculatorApi {
   
    public CompletableFuture<ResponseEntity<String>> sum(String a , String b);
    
    public CompletableFuture<ResponseEntity<String>> subtraction(String a , String b);
    
    public CompletableFuture<ResponseEntity<String>> multiplication(String a , String b);
    
    public CompletableFuture<ResponseEntity<String>> division(String a , String b);
    
}
