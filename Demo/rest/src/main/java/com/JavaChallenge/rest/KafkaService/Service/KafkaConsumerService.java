/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaChallenge.rest.KafkaService.Service;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
/**
 *
 * @author Administrator
 */
@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "my_topic_rest", groupId = "com.JavaChallenge")
    public void consume(String message) {
        System.out.println("Message received: " + message);
    }
}
