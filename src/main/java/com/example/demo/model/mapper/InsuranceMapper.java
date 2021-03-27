package com.example.demo.model.mapper;

import com.example.demo.entity.Insurance;
import com.example.demo.model.dto.InsuranceDto;

public class InsuranceMapper {
    public static InsuranceDto toInsuranceDto(Insurance insurance){
        InsuranceDto insuranceDto=new InsuranceDto();
        insuranceDto.setId(insurance.getId());
        insuranceDto.setNametype(insurance.getNametype());
        insuranceDto.setPrice(insurance.getPrice());
        return insuranceDto;
    }
}
