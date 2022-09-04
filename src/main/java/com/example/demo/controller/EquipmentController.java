package com.example.demo.controller;

import com.example.demo.dto.EquipmentDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Equipment;
import com.example.demo.error.NotFoundException;
import com.example.demo.service.EquipmentService;
import com.example.demo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.List;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    UserService userService;

    @GetMapping
    public String index(Model model) throws NotFoundException {
        List<EquipmentDto> equipmentList = equipmentService.findAllEquipments();
        List<UserDto> userList = userService.findAllUsers();
        model.addAttribute("equipmentList",equipmentList);
        model.addAttribute("userList", userList);
        return "pages/equipment";
    }
}
