package com.example.demo.dto;
import lombok.Data;

import java.util.Date;
@Data
public class EquipmentAssignmentDto {
    private Long id;
    private UserDto user;

    private Date startDate;
    private Date endDate;
}
