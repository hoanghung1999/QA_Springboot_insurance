package com.example.demo.service;
import com.example.demo.entity.Deal;
import com.example.demo.entity.User;
import com.example.demo.repository.InsuranceRepository;
import com.example.demo.entity.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceImpl implements InsuranceService{
    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public List<Insurance> getAllInsurance() {
        return insuranceRepository.findAll();
    }

    @Override
    public Insurance UpdateInsurance(Insurance insurance) {
        Optional<Insurance> insuranceDB=insuranceRepository.findById(insurance.getId());
        if(insuranceDB.isPresent()) {
            return insuranceRepository.save(insurance);
        }
        return null;
    }
    @Override
    public void deleteInsuranceById(long id) {
    insuranceRepository.deleteById(id);
    }

    @Override
    public Optional<Insurance> findInsuranceById(long id) {
        return insuranceRepository.findById(id);
    }




}
