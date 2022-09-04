package com.example.demo.service;

import com.example.demo.dto.EquipmentDto;
import com.example.demo.entity.Equipment;
import com.example.demo.error.NotFoundException;

import java.util.List;

public interface EquipmentService {

    public Equipment saveEquipment(Equipment equipment);

    public Equipment findEquipmentById(long id) throws NotFoundException;

    public List<EquipmentDto> findAllEquipments();
    public Equipment findEquipmentByName(String name);

    public Equipment updateEquipment(long id, Equipment equipment) throws NotFoundException;

}
