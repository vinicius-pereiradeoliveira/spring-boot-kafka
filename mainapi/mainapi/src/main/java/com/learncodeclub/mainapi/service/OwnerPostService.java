package com.learncodeclub.mainapi.service;

import com.learncodeclub.mainapi.client.CarPostStoreClient;
import com.learncodeclub.mainapi.dto.OwnerPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    public void createOwnerCar(OwnerPostDTO ownerPostDTO){
        carPostStoreClient.ownerPostsClient(ownerPostDTO);
    }

}
