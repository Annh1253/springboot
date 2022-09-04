package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select c from Customer c where c.firstName like %:name% or c.lastName like %:name%")
//    List<User> getByComboundNameContaining(@Param("name") String name);

//    @Query("select c from User c left join c.address a left join a.city d where c.firstName like %:name% or c.lastName like %:name% and d.cityName like %:cityName%")
//    List<User> getByNameAndCity(@Param("name") String userName, @Param("cityName") String cityName);

    @Query("select c from User c")
    List<User> getUserAvailable();

    User findByEmail(String email);
}
