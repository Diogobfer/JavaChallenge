/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.JavaChallenge.calculator.CalculationService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class CalculationService implements InterfaceCalculationService{

    private static final int DIVISION_SCALE = 30;
    private static final RoundingMode DIVISION_ROUNDING_MODE = RoundingMode.HALF_UP;

    
    
    @Override
    public String sum(String a, String b) 
    {
        BigDecimal bigDecA = convertStringToBigDecimal(a);
        BigDecimal bigDecB = convertStringToBigDecimal(b);
        String sumresult = bigDecA.add(bigDecB).toPlainString();
        return sumresult;
    }
    @Override
    public String subtraction(String a, String b)
    {
       BigDecimal bigDecA = convertStringToBigDecimal(a);
        BigDecimal bigDecB = convertStringToBigDecimal(b);
        String sumresult = bigDecA.subtract(bigDecB).toPlainString();
        return sumresult;
    }
    
    @Override
    public String multiplication(String a, String b)
    {
        BigDecimal bigDecA = convertStringToBigDecimal(a);
        BigDecimal bigDecB = convertStringToBigDecimal(b);
        String sumresult = bigDecA.multiply(bigDecB).toPlainString();
        return sumresult;
    }    

    @Override
    public String division(String a, String b) 
    {
        BigDecimal bigDecA = convertStringToBigDecimal(a);
        BigDecimal bigDecB = convertStringToBigDecimal(b);
        
        if (bigDecB.compareTo(BigDecimal.ZERO) == 0) {
           return "Division by zero is not allowed";
        }else{
            return bigDecA.divide(bigDecB, DIVISION_SCALE, DIVISION_ROUNDING_MODE).toPlainString();
        }
    }
   
    private BigDecimal convertStringToBigDecimal(String numAsString)
    {
        BigDecimal bigDecimalValue = new BigDecimal(numAsString);
        return bigDecimalValue;
    }
}
