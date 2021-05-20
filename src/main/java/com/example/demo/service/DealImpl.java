package com.example.demo.service;

import com.example.demo.repository.DealRepository;
import com.example.demo.entity.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DealImpl implements DealService{
    @Autowired
    private DealRepository dealRepository;
    @Override
    public List<Deal> getAllDeal() {
        return dealRepository.findAll();
    }
    @Override
    public Optional<Deal> getDealById(long id) {
        return Optional.empty();
    }

    @Override
    public List<Deal> getDealByNameUser(String name) {
        return null;
    }

    @Override
    public List<Deal> getDealByNameInsurance(String name) {
        return dealRepository.getAllDealByInSurName(name);
    }

    @Override
    public List<Deal> getDealByDate(String startDate, String endDate) {
        return dealRepository.getAllDealByDate(startDate,endDate);
    }
}
