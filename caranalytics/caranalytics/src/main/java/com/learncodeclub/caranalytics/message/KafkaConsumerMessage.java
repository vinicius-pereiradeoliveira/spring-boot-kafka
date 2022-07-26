package com.learncodeclub.caranalytics.message;

import com.learncodeclub.caranalytics.dto.CarPostDTO;
import com.learncodeclub.caranalytics.service.PostAnalyticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {

    private final Logger LOG = LoggerFactory.getLogger(KafkaConsumerMessage.class);
    @Autowired
    private PostAnalyticsService postAnalyticsService;

    @KafkaListener(topics = "car-post-topic", groupId = "analytics-posts-group")
    public void listening(@Payload CarPostDTO carPost) {

        System.out.println("Received Car Post information : " + carPost);
        LOG.info("Received Car Post information: {}", carPost);
        postAnalyticsService.saveDataAnalytics(carPost);

    }

}
