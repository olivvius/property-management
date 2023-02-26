package com.propertymanagement.service.impl;

import com.propertymanagement.converter.PropertyConverter;
import com.propertymanagement.dto.PropertyDTO;
import com.propertymanagement.entity.PropertyEntity;
import com.propertymanagement.repository.PropertyRepository;
import com.propertymanagement.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PropertyServiceImpl implements PropertyService {

    private PropertyRepository propertyRepository;

    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
       // System.out.println("passing through property service");
        PropertyEntity propertyEntity = propertyConverter.convertDTOtoEntity(propertyDTO);

        propertyEntity = propertyRepository.save(propertyEntity);

        PropertyDTO DTO = propertyConverter.convertEntitytoDTO(propertyEntity);
        return DTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {

        List<PropertyEntity> propertyEntityList = (List<PropertyEntity>)propertyRepository.findAll();
        List<PropertyDTO> propertyDTOList = new ArrayList<>();

        for(PropertyEntity pe : propertyEntityList){
            PropertyDTO dto = propertyConverter.convertEntitytoDTO(pe);
            propertyDTOList.add(dto);
        }

        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> opten = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(opten.isPresent()){
            PropertyEntity pe = opten.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setDescription(propertyDTO.getDescription());
            pe.setAddress(propertyDTO.getAddress());
            pe.setOwner(propertyDTO.getOwner());
            pe.setOwnerEmail(propertyDTO.getOwnerEmail());
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> opten = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(opten.isPresent()){
            PropertyEntity pe = opten.get();
            pe.setDescription(propertyDTO.getDescription());

            dto = propertyConverter.convertEntitytoDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }


    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> opten = propertyRepository.findById(propertyId);
    PropertyDTO dto = null;
        if(opten.isPresent()){
        PropertyEntity pe = opten.get();

        pe.setPrice(propertyDTO.getPrice());
        dto = propertyConverter.convertEntitytoDTO(pe);
        propertyRepository.save(pe);
    }
        return dto;
}

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }


}
