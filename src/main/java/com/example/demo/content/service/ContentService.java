package com.example.demo.content.service;

import com.example.demo.content.model.Content;
import com.example.demo.content.model.ContentDTO;
import com.example.demo.content.model.ContentMapperImpl;
import com.example.demo.content.repository.ContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    public List<ContentDTO> findAllContents() throws Exception {
        List<Content> contentList = contentRepository.findAll();
        if (contentList.size() == 0) {
            throw new Exception("Liste bos!");
        }
        List<ContentDTO> contentDTOList = new ArrayList<>();

        for(Content content:contentList){
            contentDTOList.add(ContentMapperImpl.toDTO(content));
        }

        return contentDTOList;
    }

    public ContentDTO addContent(ContentDTO contentDTO) throws Exception {

        Content content = contentRepository.save(ContentMapperImpl.toEntity(contentDTO));
        if (content.getId() == null){
            throw new Exception("Kaydedilirken hata oluştu!");
        }
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

//    public ContentDTO updateContent( String id, ContentDTO contentDTO) {
//
//        Content content = contentRepository.findTopById(id);
//
//        if(content.isPresent()){
//
//        content = contentRepository.save(ContentMapperImpl.toEntity(contentDTO));
//
//        contentRepository.save(content);
//
//        return ContentMapperImpl.toDTO(content);
//        }
//
//        return null;
//
//    }

}
