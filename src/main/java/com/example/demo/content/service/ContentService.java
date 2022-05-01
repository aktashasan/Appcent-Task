package com.example.demo.content.service;

import com.example.demo.content.model.Content;
import com.example.demo.content.model.ContentDTO;
import com.example.demo.content.model.ContentMapperImpl;
import com.example.demo.content.repository.ContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    public ContentDTO addContent(ContentDTO contentDTO) throws Exception {
        if (contentDTO == null) {
            throw new Exception("Tüm alanlar boş olamaz!");
        }
        else if (contentDTO.getFirstName() == null){
            throw new Exception("isim alani bos olamaz!");
        }
        else if(contentDTO.getLastName() == null){
            throw new Exception("Soyadi alani bos olamaz!");
        }
        else if(contentDTO.getEmail() == null){
            throw new Exception("Email alani bos olamaz!");
        }
        else if (contentDTO.getUsername() == null){
            throw new Exception("Kullanici alani bos olamaz!");
        }
        else if (contentDTO.getPassword() == null){
            throw new Exception("Sifre alani bos olamaz!");
        }
        Content content = contentRepository.save(ContentMapperImpl.toEntity(contentDTO));
        return ContentMapperImpl.toDTO(content);
    }

    public ContentDTO findContentById(String id) throws Exception{
        if (id == null){
            throw new Exception("Id boş olamaz!");
        }
        Optional<Content> optional = contentRepository.findById(id);
        if(optional.isPresent()){
            Content content = optional.get();
            return ContentMapperImpl.toDTO(content);
        }
        return null;
    }

    public Boolean deleteContentById(String id) throws Exception{
        if (id == null){
            throw new Exception("Id bos olamaz!");
        }
        contentRepository.deleteById(id);

        if(findContentById(id) == null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }




}
