package com.teuszman.workshopmongo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teuszman.workshopmongo.dto.UserDTO;
import com.teuszman.workshopmongo.entities.User;
import com.teuszman.workshopmongo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping(value = "/users")
public class UserController {
  
    @Autowired
    private UserService service;


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

        @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        User user = service.findById(id) ;
        return ResponseEntity.ok().body(user);
    }

}
