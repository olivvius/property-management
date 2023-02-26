package com.propertymanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDTO {

    private Long id;
    private String title;
    private String description;
    private String owner;
    private String ownerEmail;
    private Double price;
    private String address;


}
