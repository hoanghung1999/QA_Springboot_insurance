package com.example.demo.controller;

import com.example.demo.entity.Deal;
import com.example.demo.entity.Insurance;
import com.example.demo.entity.User;
import com.example.demo.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/insurance")
public class InsuranceController {
    @Autowired
    private InsuranceService insuranceService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Insurance>> getAllInsurance() {
        List<Insurance> allInsurance = insuranceService.getAllInsurance();
        return new ResponseEntity<>(allInsurance, HttpStatus.OK);
    }

//    @PostMapping(value = "/add")
//    public ResponseEntity<Insurance> CreatNewInsurance(@RequestBody Insurance insurance) {
//        insurance = insuranceService.saveInsurance(insurance);
//        return new ResponseEntity<>(insurance, HttpStatus.OK);
//    }

    @GetMapping(value = "/get")
    public ResponseEntity<?> getInsuranceById(@RequestParam("id") long id) {
        Optional<Insurance> insurance = insuranceService.findInsuranceById(id);
        return new ResponseEntity<>(insurance, HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<?> UpdateInsurance(@RequestBody Insurance insurance) {


        if (insuranceService.findInsuranceById(insurance.getId()).isPresent()) {
            insuranceService.UpdateInsurance(insurance);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
