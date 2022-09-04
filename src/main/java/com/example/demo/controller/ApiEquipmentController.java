package com.example.demo.controller;

import com.example.demo.dto.EquipmentDto;
import com.example.demo.entity.Equipment;
import com.example.demo.error.NotFoundException;
import com.example.demo.service.EquipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/equipment")
public class ApiEquipmentController {

    @Autowired
    EquipmentService equipmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(ApiEquipmentController.class);

    @GetMapping
    public List<EquipmentDto> findAllEquipments(){
        LOGGER.info("Inside findAllEquipments of EquipmentController");
        return equipmentService.findAllEquipments();
    }

    @GetMapping("/id/{id}")
    public Equipment findById(@PathVariable long id) throws NotFoundException {
        return equipmentService.findEquipmentById(id);
    }

    @GetMapping("/name/{name}")
    public Equipment findByName(@PathVariable String name){
        return equipmentService.findEquipmentByName(name);
    }

    @PostMapping
    public Equipment saveEquipment(@Valid @RequestBody Equipment equipment){
        LOGGER.info("Inside saveEquipment of EquipmentController");
        return equipmentService.saveEquipment(equipment);
    }

    @PatchMapping("/id/{id}")
    public Equipment updateEquipment(@PathVariable long id,@Valid @RequestBody Equipment newEquipment) throws NotFoundException {
        return equipmentService.updateEquipment(id, newEquipment);
    }

//    @GetMapping
//    Equipment findEquipmentByEmail(@RequestParam("name") String name){
//        return equipmentService.findEquipmentByName(name);
//    }


}
