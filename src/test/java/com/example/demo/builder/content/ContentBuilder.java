package com.example.demo.builder.content;

import com.example.demo.content.model.ContentDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ContentBuilder {

    private ContentDTO contentDTO = new ContentDTO();

    public ContentBuilder buildSomeDummy(){
        this.contentDTO.setFirstName("Hasan");
        this.contentDTO.setLastName("Aktas");
        this.contentDTO.setEmail("aktashasan1130@gmail.com");
        this.contentDTO.setUsername("aktashasan");
        this.contentDTO.setPassword("12345");

        return this;
    }

    public ContentBuilder withFirstName(String firstName){
        this.contentDTO.setFirstName(firstName);
        return this;
    }

    public ContentBuilder withLastName(String lastName){
        this.contentDTO.setLastName(lastName);
        return this;
    }

    public ContentBuilder withEmail(String email){
        this.contentDTO.setEmail(email);
        return this;
    }

    public ContentBuilder withUsername(String username){
        this.contentDTO.setUsername(username);
        return this;
    }

    public ContentBuilder withPassword(String password){
        this.contentDTO.setPassword(password);
        return this;
    }

    public ContentDTO build(){  return this.contentDTO;    }

}
