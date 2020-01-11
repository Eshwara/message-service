package com.kafka.consumer.repository;

import com.kafka.consumer.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, String> {
}
