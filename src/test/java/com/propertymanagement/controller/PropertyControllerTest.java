package com.propertymanagement.controller;


import com.propertymanagement.dto.PropertyDTO;
import com.propertymanagement.service.PropertyService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @InjectMocks // create a proxy object og property controller
    private PropertyController propertyController;

    @Mock // Mockito wil get this and inkect in propertycontroller prowy
    private PropertyService propertyService;

    @BeforeEach
    void init(){
        System.out.println("Test Starting");
    }

    @AfterEach
    void destroy(){
        System.out.println("End of test");
    }

    @DisplayName("testing save property method")
    @Test
    void SavePropertyMethod(){

        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setTitle("title");

        PropertyDTO savedProperty = new PropertyDTO();
        savedProperty.setId(1L);
        savedProperty.setTitle("title");

        Mockito.when(propertyService.saveProperty(propertyDTO)).thenReturn(savedProperty);
        ResponseEntity<PropertyDTO> responseEntity =  propertyController.saveProperty(propertyDTO);

        Assertions.assertNotNull(responseEntity.getBody().getId());
        Assertions.assertEquals("title", responseEntity.getBody().getTitle());
        Assertions.assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());

    }

    @DisplayName("Testing getAll method")
    @Test
    void getAllTest(){

        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        PropertyDTO propertyDTO = new PropertyDTO();

        propertyDTO.setTitle("title");
        propertyDTO.setId(1L);

        propertyDTOList.add(propertyDTO);

        Mockito.when(propertyService.getAllProperties()).thenReturn(propertyDTOList);

        ResponseEntity<List<PropertyDTO>> responseEntity = propertyController.getAllProperties();

        Assertions.assertEquals(1, responseEntity.getBody().size());
        Assertions.assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());

    }

    @DisplayName("testing patching price method")
    @Test
    void updatePriceTest(){

        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setPrice(12.0);

        PropertyDTO savedPropertyDTO = new PropertyDTO();
        savedPropertyDTO.setPrice(12.0);

        Mockito.when(propertyService.updatePropertyPrice(propertyDTO, 1L)).thenReturn(savedPropertyDTO);

        ResponseEntity<PropertyDTO> responseEntity = propertyController.updatePrice(propertyDTO, 1L);

        Assertions.assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());
        Assertions.assertEquals(12.0, responseEntity.getBody().getPrice());
    }




}
