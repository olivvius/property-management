package com.propertymanagement.converter;

import com.propertymanagement.dto.PropertyDTO;
import com.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity propertyEntity = new PropertyEntity();

        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setAddress(propertyDTO.getAddress());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setOwner(propertyDTO.getOwner());
        propertyEntity.setPrice(propertyDTO.getPrice());
        propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());

        return propertyEntity;
    }

    public PropertyDTO convertEntitytoDTO(PropertyEntity propertyEntity){
        PropertyDTO propertyDTO = new PropertyDTO();

        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setOwner(propertyEntity.getOwner());
        propertyDTO.setPrice(propertyEntity.getPrice());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());

        return propertyDTO;
    }



}
