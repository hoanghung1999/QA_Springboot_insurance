package com.example.demo.model.mapper;

import com.example.demo.entity.Deal;
import com.example.demo.model.dto.DealDto;

public class DealMapper {
    public static DealDto toDealDto(Deal deal){
        DealDto dealDto=new DealDto();
        dealDto.setId(deal.getId());
        dealDto.setDurantion(deal.getDurantion());
        dealDto.setTimeComplete(deal.getTimeComplete());
        dealDto.setStatus(deal.getStatus());
        dealDto.setTotalBill(deal.getTotalBill());
        return dealDto;
    }
}
