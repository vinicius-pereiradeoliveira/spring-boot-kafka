package com.learncodeclub.store.service;


import com.learncodeclub.store.dto.OwnerPostDTO;
import com.learncodeclub.store.entity.OwnerPostEntity;
import com.learncodeclub.store.respository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostService {

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    public void createOwnerPost(OwnerPostDTO ownerPostDTO){
        OwnerPostEntity ownerPost = new OwnerPostEntity();
        ownerPost.setName(ownerPostDTO.getName());
        ownerPost.setType(ownerPostDTO.getType());
        ownerPost.setContactNumber(ownerPostDTO.getContactNumber());

        ownerPostRepository.save(ownerPost);
    }


}
