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
