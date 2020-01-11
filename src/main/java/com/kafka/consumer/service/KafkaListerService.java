package com.kafka.consumer.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.consumer.model.Message;
import com.kafka.consumer.repository.MessageRepository;
import com.kafka.consumer.util.MessageRequest;
import com.kafka.consumer.util.MobileDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class KafkaListerService {

    @Autowired
    private MessageRepository messageRepository;

    @KafkaListener(topics = "test")
    public void listen(String message) {
        System.out.println("Received Messasge in group  " + message);
        ObjectMapper objectMapper = new ObjectMapper();
        MessageRequest messageRequest = null;
        try {
           messageRequest =  objectMapper.readValue(message, MessageRequest.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        if(messageRequest != null){

            String msg = messageRequest.getMessage();

            for(MobileDetails mobileDetails : messageRequest.getMobiles()){

                Message message1 = new Message();
                message1.setMessage(msg);
                message1.setId(mobileDetails.getId());
                message1.setMobile(mobileDetails.getMobile());
                message1.setStatus("Pending");
                messageRepository.save(message1);
            }

        }
    }

}
