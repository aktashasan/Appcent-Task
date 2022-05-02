package com.example.demo.builder.content;

import com.example.demo.content.model.ContentDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ContentBuilder {

    private ContentDTO contentDTO = new ContentDTO();

    public ContentBuilder buildSomeDummy(){
        this.contentDTO.setExplanation("makarna,ekmek");
        this.contentDTO.setTitle("#Alışveriş");
        this.contentDTO.setPriority("1.öncelik");
        this.contentDTO.setTicket("@ev");

        return this;
    }

    public ContentBuilder withExplanation(String explanation){
        this.contentDTO.setExplanation(explanation);
        return this;
    }

    public ContentBuilder withTitle(String title){
        this.contentDTO.setTitle(title);
        return this;
    }

    public ContentBuilder withPriority(String priority){
        this.contentDTO.setPriority(priority);
        return this;
    }

    public ContentBuilder withTicket(String ticket){
        this.contentDTO.setTicket(ticket);
        return this;
    }

    public ContentDTO build(){  return this.contentDTO;    }

}
