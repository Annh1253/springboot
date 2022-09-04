package com.example.demo.dto;

import com.example.demo.entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class UserDto {

    private long id;

    private String firstName;

    private String lastName;

    private String email;


    private String password;

    private boolean gender;

    private Date birthDate;

    private Boolean deleteAt;

    private List<Role> roleList = new ArrayList<>();

    @JsonIgnore
    private List<EquipmentDto> equipmentList;

    private Date createAt;

    private Date updateAt;
}
