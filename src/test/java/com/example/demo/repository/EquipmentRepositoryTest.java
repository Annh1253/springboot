package com.example.demo.repository;

import com.example.demo.entity.Equipment;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EquipmentRepositoryTest {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Test
    public void saveEquipment(){
        User user = User.builder().firstName("Nguyen").build();
        Equipment equipment = Equipment.builder()
                .name("laptop")
                .user(user)
                .build();
        equipmentRepository.save(equipment);
    }
}