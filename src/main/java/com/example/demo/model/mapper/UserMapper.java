package com.example.demo.model.mapper;

import com.example.demo.entity.User;
import com.example.demo.model.dto.UserDto;

public class UserMapper {
    public static UserDto toUserDto(User user){
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setFullname(user.getFullname());
        userDto.setTypeuser(user.getTypeuser());
        userDto.setAddress(user.getAddress());
        return userDto;
    }
}
