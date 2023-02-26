package com.propertymanagement.controller;


import com.propertymanagement.dto.CalculatorDTO;
import jakarta.inject.Inject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
    @InjectMocks
    private CalculatorController calculatorController;

    @BeforeEach
    void init(){
        System.out.println("Test Starting");
    }

    @AfterEach
    void destroy(){
        System.out.println("End of test");
    }

    @DisplayName("testing add method")
    @Test
    void testAdd(){
        Double result = calculatorController.add(3.5, 3.5);
        //expecting 7.0
        Assertions.assertEquals(7.0, result);
    }

    @DisplayName("testing substract method")
    @Test
    void testSub(){
        Double result = calculatorController.substract(5.0, 4.0);
        Assertions.assertEquals(1.0, result);
    }

    @DisplayName("testing multiply method")
    @Test
    void testMultiply(){
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setNum1(1.0);
        calculatorDTO.setNum2(2.0);
        calculatorDTO.setNum3(3.0);
        calculatorDTO.setNum4(4.0);
        ResponseEntity<Double> responseEntity =  calculatorController.multiply(calculatorDTO);
        Assertions.assertEquals(24.0, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());

    }

}
