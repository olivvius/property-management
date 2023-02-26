package com.propertymanagement.controller;

import com.propertymanagement.dto.PropertyDTO;
import com.propertymanagement.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    private PropertyService propertyService;
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        PropertyDTO DTO = propertyService.saveProperty(propertyDTO);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(DTO, HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        List<PropertyDTO> propertyList = propertyService.getAllProperties();
         ResponseEntity<List<PropertyDTO>> responseEntity= new ResponseEntity<>(propertyList, HttpStatus.OK);
         return responseEntity;
    }
    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> update(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){

        PropertyDTO DTO = propertyService.updateProperty(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(DTO, HttpStatus.CREATED);
        return  responseEntity;
    }

    @PatchMapping ("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDTO> updateDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {

        PropertyDTO DTO = propertyService.updatePropertyDescription(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(DTO, HttpStatus.CREATED);
        return responseEntity;
    }
    @PatchMapping ("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId) {

        PropertyDTO DTO = propertyService.updatePropertyPrice(propertyDTO, propertyId);
        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(DTO, HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        return  responseEntity;
    }


}
