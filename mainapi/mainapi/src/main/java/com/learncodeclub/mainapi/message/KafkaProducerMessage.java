package com.learncodeclub.mainapi.message;

import com.learncodeclub.mainapi.dto.CarPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component // this annotation inform Spring Boot that this class can be manage with the framework
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, CarPostDTO> kafkaTemplate;

    private final String KAFKA_TOPIC = "car-post-topic";

    public void sendMessage(CarPostDTO carPostDTO){
        kafkaTemplate.send(KAFKA_TOPIC, carPostDTO);
    }

}
