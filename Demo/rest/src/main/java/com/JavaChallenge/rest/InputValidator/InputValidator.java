/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaChallenge.rest.InputValidator;


import org.springframework.stereotype.Service;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author Administrator
 */
@Service
public class InputValidator implements InterfaceInputValidator {
    
    private static final String IS_VALID_NUMBER_REGEX = "[-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?$";
    private static final Pattern PATTERN = Pattern.compile(IS_VALID_NUMBER_REGEX); 
    
    @Override
    public boolean checkInput(String  numberAsString)
    {
        //check if the value is null or empty 
        if(numberAsString.isBlank())
        {
          System.out.print("The number is empty , "+ numberAsString);
           return false;
        }
        //chech if is a valid number
        Matcher matcher = PATTERN.matcher(numberAsString);
        System.out.print("The is a valid number , "+ matcher.matches());
        return matcher.matches();
    }
     
}
