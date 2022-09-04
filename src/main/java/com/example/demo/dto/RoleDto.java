package com.example.demo.dto;

import com.example.demo.enums.RoleName;
import lombok.Data;

@Data
public class RoleDto {

    private int id;

    private RoleName roleName;
}
