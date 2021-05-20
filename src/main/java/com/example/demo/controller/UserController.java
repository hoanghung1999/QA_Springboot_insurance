package com.example.demo.controller;

import com.example.demo.entity.Insurance;
import com.example.demo.entity.User;
import com.example.demo.service.InsuranceService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping("/")
    public ResponseEntity<List<User>> getAllUser(Model model) {
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User userSave=userService.saveUser(user);
        System.out.println(userSave.getFullname());
        return new ResponseEntity<>(userSave,HttpStatus.OK);
    }

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public ResponseEntity<List<User>> findUserByName(@RequestParam("name") String name){
        List<User> listUser=userService.findUserByName(name);
        return new ResponseEntity<>(listUser,HttpStatus.OK);

    }
    @RequestMapping(value = "insurance",method = RequestMethod.GET)
    public ResponseEntity<List<User>> findUserByInsurName(@RequestParam("name") String name){
        List<User> listUser=userService.findUserByInsurName(name);
        return new ResponseEntity<>(listUser,HttpStatus.OK);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> editUser(@PathVariable("id") Long userId) {
            Optional<User> user= userService.findUserById(userId);
            if(!user.isPresent()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        System.out.println(user.get().getInsurance().getId()+" "+ user.get().getInsurance().getPrice());
            return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseEntity<User> UpdateUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResponseEntity<?> deleteUser(@RequestParam("id") Long userId) {
        Optional<User> user =userService.findUserById(userId);
        if(user.isPresent()) {
            userService.deleteUserById(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping(value = "save")
    public ResponseEntity<?> test(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}