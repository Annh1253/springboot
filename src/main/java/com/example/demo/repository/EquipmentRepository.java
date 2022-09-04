package com.example.demo.repository;

import com.example.demo.entity.Equipment;
import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    Equipment findByName(String name);
}
