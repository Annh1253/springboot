package com.example.demo.controller;

import com.example.demo.entity.Equipment;
import com.example.demo.service.EquipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(ApiEquipmentController.class)
class ApiEquipmentControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @MockBean
    private EquipmentService equipmentService;

    private Equipment equipment;

    @BeforeEach
    void setUp(){

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        equipment = Equipment.builder()
                .name("may tinh")
                .build();
    }

    @Test
    void findById() {
    }

    @Test
    void saveEquipment() throws Exception {
        Equipment inputEquipment = Equipment.builder()
                .name("may tinh")
                .build();
        Mockito.when(equipmentService.saveEquipment(inputEquipment))
                .thenReturn(equipment);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/equipment/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"id\": 8,\n" +
                        "    \"name\": \"asd123\"\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}