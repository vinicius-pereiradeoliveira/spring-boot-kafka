package com.learncodeclub.store.service;

import com.learncodeclub.store.dto.CarPostDTO;
import com.learncodeclub.store.entity.CarPostEntity;
import com.learncodeclub.store.respository.CarPostRepository;
import com.learncodeclub.store.respository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostService {

    @Autowired
    private CarPostRepository carPostRepository;

    @Autowired
    private OwnerPostRepository ownerPostRepository;

    public void newPostDetails(CarPostDTO carPostDTO){
        CarPostEntity carPostEntity = mapCarDtoToEntity(carPostDTO);
        carPostRepository.save(carPostEntity);
    }

    public List<CarPostDTO> getCarSales() {
        List<CarPostDTO> listCarsSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item->{
            listCarsSales.add(mapCarEntityToDTO(item));
        });
        return listCarsSales;
    }

    public void changeCarSale(CarPostDTO carPostDTO, Long postId) {
        carPostRepository.findById(postId).ifPresentOrElse(item->{
            item.setDescription(carPostDTO.getDescription());
            item.setContact(carPostDTO.getContact());
            item.setPrice(carPostDTO.getPrice());
            item.setBrand(carPostDTO.getBrand());
            item.setEngineVersion(carPostDTO.getEngineVersion());
            item.setModel(carPostDTO.getModel());

            carPostRepository.save(item);

        }, ()-> {
            throw new NoSuchElementException();
        });
    }

    public void removeCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }

    private CarPostEntity mapCarDtoToEntity(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = new CarPostEntity();

        ownerPostRepository.findById(carPostDTO.getOwnerId()).ifPresentOrElse(item->{
            carPostEntity.setOwnerPost(item);
            carPostEntity.setContact(item.getContactNumber());
        }, ()-> {
            throw new RuntimeException();
        });

        carPostEntity.setModel(carPostDTO.getModel());
        carPostEntity.setBrand(carPostDTO.getBrand());
        carPostEntity.setPrice(carPostDTO.getPrice());
        carPostEntity.setCity(carPostDTO.getCity());
        carPostEntity.setDescription(carPostDTO.getDescription());
        carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());
        carPostEntity.setCreatedDate(String.valueOf(new Date()));

        return carPostEntity;
    }

    private CarPostDTO mapCarEntityToDTO(CarPostEntity carPostEntity){

        return CarPostDTO.builder()
                .brand(carPostEntity.getBrand())
                .city(carPostEntity.getCity())
                .model(carPostEntity.getModel())
                .description(carPostEntity.getDescription())
                .engineVersion(carPostEntity.getEngineVersion())
                .createdDate(carPostEntity.getCreatedDate())
                .ownerName(carPostEntity.getOwnerPost().getName())
                .price(carPostEntity.getPrice()).build();

    }

}