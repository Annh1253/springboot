package com.example.demo.service;

import com.example.demo.dto.EquipmentDto;
import com.example.demo.entity.Equipment;
import com.example.demo.error.NotFoundException;
import com.example.demo.helper.DtoHelper;
import com.example.demo.repository.EquipmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    private  DtoHelper dtoHelper;

    @Override
    public Equipment saveEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public Equipment findEquipmentById(long id) throws NotFoundException {
        Optional<Equipment> equipment =equipmentRepository.findById(id);
        if(!equipment.isPresent()){
            throw new NotFoundException("Equipment Not Found");
        }

        return equipment.get();
    }

    @Override
    public List<EquipmentDto> findAllEquipments() {
        List<Equipment> equipmentList =  equipmentRepository.findAll();
        for(Equipment equipment : equipmentList){
            System.out.println(equipment);
        }
        List<EquipmentDto> equipmentDtoList = dtoHelper.mapList(equipmentList, EquipmentDto.class);
        return equipmentDtoList;
    }

    @Override
    public Equipment findEquipmentByName(String name) {
        return equipmentRepository.findByName(name);
    }

    @Override
    public Equipment updateEquipment(long id, Equipment newEquipment) throws NotFoundException {
        Optional<Equipment> oldEquipmentRecord = equipmentRepository.findById(id);
        if(!oldEquipmentRecord.isPresent())
        {
           throw new NotFoundException("Equipment Not Found");
        }else{
            Equipment oldEquipment = oldEquipmentRecord.get();
            if(Objects.nonNull(newEquipment.getName()))
                oldEquipment.setName(newEquipment.getName());
            return equipmentRepository.save(oldEquipment);
        }
    }
}
