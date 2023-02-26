package com.propertymanagement.service;

import com.propertymanagement.converter.PropertyConverter;
import com.propertymanagement.dto.PropertyDTO;
import com.propertymanagement.entity.PropertyEntity;
import com.propertymanagement.repository.PropertyRepository;
import com.propertymanagement.service.impl.PropertyServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceTest {

    @InjectMocks
    PropertyServiceImpl propertyService;

    @Mock
    PropertyConverter propertyConverter;

    @Mock
    PropertyRepository propertyRepository;

    @BeforeEach
    void init(){
        System.out.println("Test Starting");
    }

    @AfterEach
    void destroy(){
        System.out.println("End of test");
    }

    @DisplayName("testing save method")
    @Test
    void saveProperty(){

        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setTitle("title");
        propertyDTO.setPrice(12.0);

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle("title");

        PropertyEntity savedProperty = new PropertyEntity();
        savedProperty.setTitle("title");
        savedProperty.setId(1L);

        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("title");
        savedDTO.setId(1L);

        Mockito.when(propertyConverter.convertDTOtoEntity(Mockito.any())).thenReturn(propertyEntity);
        Mockito.when(propertyRepository.save(Mockito.any())).thenReturn(savedProperty);
        Mockito.when(propertyConverter.convertEntitytoDTO(Mockito.any())).thenReturn(savedDTO);
        PropertyDTO result = propertyService.saveProperty(propertyDTO);

        Assertions.assertEquals(savedDTO.getId(), result.getId());

    }

    @DisplayName("testing getting all properties from service")
    @Test
    void GetAllPropertiesTest(){

        List<PropertyEntity> propertyEntities = new ArrayList<>();
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setId(1L);
        propertyEntity.setTitle("title");

        propertyEntities.add(propertyEntity);

        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("title");
        savedDTO.setId(1L);


        Mockito.when(propertyRepository.findAll()).thenReturn(propertyEntities);
        Mockito.when(propertyConverter.convertEntitytoDTO(Mockito.any())).thenReturn(savedDTO);
        List<PropertyDTO> propertyDTOList = propertyService.getAllProperties();

        Assertions.assertEquals(1, propertyDTOList.size());

    }

    @DisplayName("testing update property")
    @Test
    void updatePropertyTest(){

        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("title");
        savedDTO.setId(1L);
        savedDTO.setPrice(12.0);
        savedDTO.setAddress("new york");
        savedDTO.setDescription("desc");
        savedDTO.setOwner("bean");
        savedDTO.setOwnerEmail("beanmail");


        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle("title");
        propertyEntity.setId(1L);
        propertyEntity.setPrice(12.0);
        propertyEntity.setAddress("new york");
        propertyEntity.setDescription("desc");
        propertyEntity.setOwner("bean");
        propertyEntity.setOwnerEmail("beanmail");

        Mockito.when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(propertyEntity));
        Mockito.when(propertyConverter.convertEntitytoDTO(Mockito.any())).thenReturn(savedDTO);

        PropertyDTO propertyDTO = propertyService.updateProperty(savedDTO, 1L);

        Assertions.assertEquals(savedDTO.getTitle(), propertyDTO.getTitle());
    }




}
