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
        content.setExplanation(contentDTO.getExplanation());
        content.setTitle(contentDTO.getTitle());
        content.setPriority(contentDTO.getPriority());
        content.setTicket(contentDTO.getTicket());

        return content;
    }

    public static ContentDTO toDTO(Content content){
        if (content == null) {
            return null;
        }

        ContentDTO contentDTO = new ContentDTO();

        contentDTO.setId(content.getId());
        contentDTO.setExplanation(content.getExplanation());
        contentDTO.setTitle(content.getTitle());
        contentDTO.setPriority(content.getPriority());
        contentDTO.setTicket(content.getTicket());

        return contentDTO;
    }

}
