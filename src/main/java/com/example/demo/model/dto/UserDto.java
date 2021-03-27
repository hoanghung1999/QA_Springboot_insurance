package com.example.demo.model.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
public class UserDto {
    private Long id;
    private String fullname;
    private String typeuser;
    private String address;
}
