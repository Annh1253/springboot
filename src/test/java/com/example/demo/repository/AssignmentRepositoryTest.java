package com.example.demo.repository;

import com.example.demo.entity.Assignment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssignmentRepositoryTest {

    @Autowired
    AssignmentRepository assignmentRepository;

    @Test
    public void getAllAssignments(){
        List<Assignment> assignmentList = assignmentRepository.findAll();
        for(Assignment assignment : assignmentList){
            System.out.println(assignment.getUser());
            System.out.println(assignment.getEquipment());
        }
    }
}