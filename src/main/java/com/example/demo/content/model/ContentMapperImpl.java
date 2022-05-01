package com.example.demo.content.model;

import org.springframework.stereotype.Component;

@Component
public class ContentMapperImpl {

    public static Content toEntity(ContentDTO contentDTO){
        if (contentDTO == null) {
            return null;
        }

        Content content = new Content();

        content.setId(contentDTO.getId());
        content.setFirstName(contentDTO.getFirstName());
        content.setLastName(contentDTO.getLastName());
        content.setEmail(contentDTO.getEmail());
        content.setUsername(contentDTO.getUsername());
        content.setPassword(contentDTO.getPassword());

        return content;
    }

    public static ContentDTO toDTO(Content content){
        if (content == null) {
            return null;
        }

        ContentDTO contentDTO = new ContentDTO();

        contentDTO.setId(content.getId());
        contentDTO.setFirstName(content.getFirstName());
        contentDTO.setLastName(content.getLastName());
        contentDTO.setEmail(content.getEmail());
        contentDTO.setUsername(content.getUsername());
        contentDTO.setPassword(content.getPassword());

        return contentDTO;
    }

}
