package com.example.demo.dto;
import lombok.Data;


@Data
public class EquipmentDto {

    private long id;

    private String name;

    private String description;

    private CategoryDto category;

    private UserDto user;

    private EquipmentAssignmentDto assignment;
}
