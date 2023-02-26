package com.propertymanagement.converter;

import com.propertymanagement.dto.PropertyDTO;
import com.propertymanagement.entity.PropertyEntity;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyConverterTest {

    @InjectMocks
    private PropertyConverter propertyConverter;

    @BeforeEach
    void init(){
        System.out.println("Test Starting");
    }

    @AfterEach
    void destroy(){
        System.out.println("End of test");
    }

    @DisplayName("test conversion from dto to entity")
    @Test
    void convertDTOtoEntityTest(){

        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setTitle("title");
        propertyDTO.setPrice(12.0);

        PropertyEntity propertyEntity = propertyConverter.convertDTOtoEntity(propertyDTO);

        Assertions.assertEquals("title", propertyEntity.getTitle());
        Assertions.assertEquals(12.0, propertyEntity.getPrice());


    }

    @DisplayName("testing conversion from entity to dto")
    @Test
    void convertEntityToDTOTest(){

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setPrice(12.0);
        propertyEntity.setTitle("title");

        PropertyDTO propertyDTO = propertyConverter.convertEntitytoDTO(propertyEntity);

        Assertions.assertEquals(propertyEntity.getPrice(), propertyDTO.getPrice());
        Assertions.assertEquals(propertyEntity.getTitle(), propertyDTO.getTitle());

    }



}
