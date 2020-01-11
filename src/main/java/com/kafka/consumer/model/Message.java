package com.kafka.consumer.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
@Data
public class Message {

    @Id
    private String id;
    private String mobile;
    private String message;
    private String status;

}
