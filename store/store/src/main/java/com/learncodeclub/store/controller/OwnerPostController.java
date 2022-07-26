package com.learncodeclub.store.controller;

import com.learncodeclub.store.dto.OwnerPostDTO;
import com.learncodeclub.store.service.OwnerPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class OwnerPostController {

    @Autowired
    private OwnerPostService ownerPostService;

    @PostMapping
    public ResponseEntity createOwner(@RequestBody OwnerPostDTO ownerPostDTO){
        ownerPostService.createOwnerPost(ownerPostDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
