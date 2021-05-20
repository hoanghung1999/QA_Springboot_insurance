package com.example.demo.entity;

import com.example.demo.model.dto.InsuranceDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.InsuranceMapper;
import com.example.demo.model.mapper.UserMapper;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Deal")
@Data
public class Deal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "timeComplete")
    private Date timeComplete;
    @Column(name = "totalBill")
    private Float totalBill;
    @Column(name = "status")
    private String status;
    @Column(name = "durantion")
    private Date durantion;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id") // thông qua khóa ngoại address_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "insurance_id") // thông qua khóa ngoại address_id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Insurance insurance;

    public UserDto getUserDto(){
        UserDto userDto=new UserDto();
        userDto=UserMapper.toUserDto(user);
        return userDto;
    }
    public InsuranceDto getInsuranceDto(){
        InsuranceDto insuranceDto=new InsuranceDto();
        insuranceDto= InsuranceMapper.toInsuranceDto(insurance);
        return insuranceDto;
    }

}
