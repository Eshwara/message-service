package com.kafka.consumer.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

public class MessageRequestDeserializer implements Deserializer<MessageRequest> {

    @Override
    public MessageRequest deserialize(String s, byte[] bytes) {

            ObjectMapper mapper = new ObjectMapper();
        MessageRequest messageRequest = null;
            try {
                messageRequest = mapper.readValue(s, MessageRequest.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return messageRequest;

    }
}
