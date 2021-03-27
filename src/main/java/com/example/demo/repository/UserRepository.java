package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user u where u.fullname like %?1%",nativeQuery = true)
    public List<User> findByName(String name);
    @Query(value = "select * FROM user u JOIN insurance i ON u.insurance_id=i.id WHERE i.nametype=?1",nativeQuery = true)
    public List<User> findUserByInsuranceName(String name);
}