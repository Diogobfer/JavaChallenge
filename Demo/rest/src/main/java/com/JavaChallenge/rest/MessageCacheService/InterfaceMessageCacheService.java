/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.JavaChallenge.rest.MessageCacheService;

import java.util.concurrent.CompletableFuture;

/**
 *
 * @author Administrator
 */
public interface InterfaceMessageCacheService {
    
    public void storeMessage(String msg);
    public CompletableFuture<String> checkMessage(String ID);
}
