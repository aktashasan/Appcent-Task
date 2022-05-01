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
    private String firstName;

    @Field
    private String lastName;

    @Field
    private String email;

    @Field
    private String username;

    @Field
    private String password;
}
