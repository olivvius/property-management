package com.propertymanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "PROPERTY_TABLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PROPERTY_TITLE", nullable = false)
    private String title;

    private String description;
    private String owner;
    @Column(name = "EMAIL")
    private String ownerEmail;
    private Double price;
    private String address;

    public PropertyEntity(String title, String description, String owner, String ownerEmail, Double price, String address) {
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.ownerEmail = ownerEmail;
        this.price = price;
        this.address = address;
    }
}
