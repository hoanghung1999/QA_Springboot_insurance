package com.example.demo.service;

import com.example.demo.entity.Deal;

import java.util.List;
import java.util.Optional;

public interface DealService {
    public List<Deal> getAllDeal();
    public Optional<Deal> getDealById(long id);
    public List<Deal> getDealByNameUser(String name);
    public List<Deal> getDealByNameInsurance(String name);
    public List<Deal> getDealByDate(String startDate,String endDate);

}
