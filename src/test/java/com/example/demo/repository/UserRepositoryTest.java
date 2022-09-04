package com.example.demo.repository;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.enums.RoleName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;


    @Test
    public void saveUser(){
        User user = new User();
        user.setEmail("emem1253@gmail.com");
        user.setPassword("$2a$12$Zxh4aeratNMkpBfBpykaQO1AaglBVwMybkV.mpNem1vTDQUEt2rHO");
        Role userRole = Role.builder()
                .roleName(RoleName.ROLE_EMPLOYEE)
                .build();
        user.addRole(userRole);
        userRepository.save(user);
    }

    @Test
    public  void testDeleteUser(){
        Long USER_ID = Long.valueOf(1);
        User user = userRepository.findById(USER_ID).get();
        userRepository.delete(user);
    }

    @Test
    public void testGetAll(){

        List<User> userList = userRepository.getUserAvailable();
        for(User user : userList){
            System.out.println(user);
        }

    }

    @Test
    public void findUserByEmail(){
        User user = userRepository.findByEmail("123");
        System.out.println(user);
    }

}