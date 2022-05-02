package com.example.demo.content.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
@Data
@Document
public class Content implements Serializable {

    @Id
    private String id;

    @Field
    private String explanation;

    @Field
    private String title;

    @Field
    private String priority;

    @Field
    private String ticket;

}
