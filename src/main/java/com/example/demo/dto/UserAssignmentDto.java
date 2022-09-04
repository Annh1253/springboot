package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserAssignmentDto {
    private Long id;
    private EquipmentDto equipment;
    private Date startDate;
    private Date endDate;
}
