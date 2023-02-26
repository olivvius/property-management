package com.propertymanagement.dto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DTOtester {

    @DisplayName("testing all dtos")
    @Test
    void testAllDTOs(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(CalculatorDTO.class);
        beanTester.testBean(PropertyDTO.class);
    }


}
