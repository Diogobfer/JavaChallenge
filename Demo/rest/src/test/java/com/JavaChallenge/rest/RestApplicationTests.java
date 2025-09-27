package com.JavaChallenge.rest;

import com.JavaChallenge.rest.CalculatorApi.CalculatorApi;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class RestApplicationTests {
    private final long TEST_TIMEOUT_SECONDS = 5; 
    private final CalculatorApi calculatorApi;
    
    @Autowired
    public RestApplicationTests(CalculatorApi calculatorApi) {
        this.calculatorApi = calculatorApi;
    }
      
    
    //----------------Teste Input chech A and B
    @Test
    void sumInvalidInputTestA() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "DOIS";
        String b = "5";

        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.sum(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals("Error: Invalid input. Both parameters must be valid numbers.", response.getBody());
    }
    @Test
    void sumInvalidInputTestB() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "8";
        String b = "DOIS";

        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.sum(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals("Error: Invalid input. Both parameters must be valid numbers.", response.getBody());
    }
    
    // ----------------- SUM -----------------
    @Test
    void sumValidTest() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "2";
        String b = "5";
        
        BigDecimal expected = new BigDecimal(a).add(new BigDecimal(b));
        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.sum(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals(expected.toPlainString(), response.getBody());
    }
    
    @Test
    void sumExponentialTest() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "45e34";
        String b = "1e2";

        BigDecimal expected = new BigDecimal(a).add(new BigDecimal(b));

        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.sum(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals(expected.toPlainString(), response.getBody());
    }
    @Test
    void sumExponentialTestNinus() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "-5e23";
        String b = "43e21";

        BigDecimal expected = new BigDecimal(a).add(new BigDecimal(b));

        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.sum(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals(expected.toPlainString(), response.getBody());
    }
    
    
    // ----------------- SUBTRACTION -----------------
    @Test
    void subtractionValidTest() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "10";
        String b = "4";
        
        BigDecimal expected = new BigDecimal(a).subtract(new BigDecimal(b));
        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.subtraction(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals(expected.toPlainString(), response.getBody());
    }
    @Test
    void subtractionExponentialTest() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "45e34";
        String b = "1e2";

        BigDecimal expected = new BigDecimal(a).subtract(new BigDecimal(b));

        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.subtraction(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals(expected.toPlainString(), response.getBody());
    }
    @Test
    void subtractionExponentialTestMinus() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "20e34";
        String b = "-15e2";

        BigDecimal expected = new BigDecimal(a).subtract(new BigDecimal(b));

        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.subtraction(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals(expected.toPlainString(), response.getBody());
    }


    // ----------------- MULTIPLICATION -----------------
    @Test
    void multiplicationValidTest() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "3";
        String b = "5";
        
        BigDecimal expected = new BigDecimal(a).multiply(new BigDecimal(b));
        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.multiplication(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals(expected.toPlainString(), response.getBody());
    }
    
    // ----------------- MULTIPLICATION -----------------
    @Test
    void multiplicationExponentialTest() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "45e46";
        String b = "1e2";

        BigDecimal expected = new BigDecimal(a).multiply(new BigDecimal(b));

        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.multiplication(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals(expected.toPlainString(), response.getBody());
    }
    @Test
    void multiplicationExponentialTestNinus() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "45e46";
        String b = "-1e2";

        BigDecimal expected = new BigDecimal(a).multiply(new BigDecimal(b));

        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.multiplication(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals(expected.toPlainString(), response.getBody());
    }

   

    // ----------------- DIVISION -----------------
    @Test
    void divisionValidTest() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "20";
        String b = "4";

        BigDecimal expected = new BigDecimal(a).divide(new BigDecimal(b));
        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.division(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals(expected.toPlainString(), response.getBody());
    }
    @Test
    void divisionValidTestNinus() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "-20";
        String b = "4";
        
        BigDecimal expected = new BigDecimal(a).divide(new BigDecimal(b));
        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.division(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals(expected.toPlainString(), response.getBody());
    }
    
    
    
    @Test
    void divisionCheckZeroDivisorTest() throws InterruptedException, ExecutionException, TimeoutException {
    String a = "20";
    String b = "0";

    
    CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.division(a, b);
    ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

   
    assertEquals("Division by zero is not allowed", response.getBody());
    }
    
    @Test
    void divisionExponentialTest() throws InterruptedException, ExecutionException, TimeoutException {
        String a = "45e34";
        String b = "1e2";

        BigDecimal expected = new BigDecimal(a).divide(new BigDecimal(b), 30, RoundingMode.HALF_UP); 
        

        CompletableFuture<ResponseEntity<String>> futureResponse = calculatorApi.division(a, b);
        ResponseEntity<String> response = futureResponse.get(TEST_TIMEOUT_SECONDS, TimeUnit.SECONDS);

        assertEquals(expected.toPlainString(), response.getBody());
    }
    

}
