package com.learncodeclub.mainapi.service;

import com.learncodeclub.mainapi.client.CarPostStoreClient;
import com.learncodeclub.mainapi.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarPostStoreService {

    @Autowired
    private CarPostStoreClient carPostStoreClient;

    public List<CarPostDTO> getCarForSales(){
        return carPostStoreClient.carForSaleClient();
    }

    public void changeCarForSale(CarPostDTO carPostDTO, String id){
        carPostStoreClient.changeCarForSaleClient(carPostDTO, id);
    }

    public void removeCarForSale(String id) {
        carPostStoreClient.deleteCarForSaleClient(id);
    }

}
