package com.example.demo.service;

import com.example.demo.entity.Deal;
import com.example.demo.entity.Insurance;
import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface InsuranceService {
    public List<Insurance> getAllInsurance();
    public Insurance UpdateInsurance(Insurance insurance);
    public void deleteInsuranceById(long id);
    public Optional<Insurance> findInsuranceById(long id);

}
