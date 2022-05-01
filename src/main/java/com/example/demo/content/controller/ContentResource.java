package com.example.demo.content.controller;

import com.example.demo.content.model.ContentDTO;
import com.example.demo.content.service.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
@AllArgsConstructor
public class ContentResource {

    private ContentService contentService;

    @PostMapping("/content/save")
    public ResponseEntity<ContentDTO> addContent (@RequestBody ContentDTO contentDTO) throws Exception {
        return ResponseEntity.ok(contentService.addContent(contentDTO));
    }

    @GetMapping("/content/get/id/{id}")
    public ResponseEntity<ContentDTO> findContentById(@PathVariable String id) throws Exception{
        ContentDTO contentDTO = contentService.findContentById(id);
        if (contentDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contentDTO);
    }

    @GetMapping("/content/delete/{id}")
    public ResponseEntity<Boolean> deleteContentById(@PathVariable String id) throws Exception{
        return ResponseEntity.ok(contentService.deleteContentById(id));
    }

}
