package com.example.demo.controller;

import com.example.demo.entity.Deal;
import com.example.demo.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/deals")
public class DealController {
    @Autowired
    private DealService dealService;
    @GetMapping(value = "/")
    public ResponseEntity<List<Deal>> getAllDeal(){
        List<Deal> dealAll= dealService.getAllDeal();

        return new ResponseEntity<>(dealAll, HttpStatus.OK);
    }
    @GetMapping(value = "/insurance")
    public ResponseEntity<List<Deal>> getDealByInsurName(@RequestParam("name") String name){
        List<Deal> dealhasInsur= dealService.getDealByNameInsurance(name);
        return new ResponseEntity<>(dealhasInsur, HttpStatus.OK);
    }

    @GetMapping(value="/get")
    public ResponseEntity<List<Deal>> getDealByDate(@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate ){
    List<Deal> dealByDate=dealService.getDealByDate(startDate,endDate);
    return new ResponseEntity<>(dealByDate,HttpStatus.OK);
    }
}
