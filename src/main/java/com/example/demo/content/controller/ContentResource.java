package com.example.demo.content.controller;

import com.example.demo.content.model.ContentDTO;
import com.example.demo.content.service.ContentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@AllArgsConstructor
public class ContentResource {

    private ContentService contentService;

    @PostMapping("/content/save")
    public ResponseEntity<ContentDTO> addContent (@RequestBody ContentDTO contentDTO) throws Exception {
        return ResponseEntity.ok(contentService.addContent(contentDTO));
    }

    @GetMapping("/contents/get")
    public ResponseEntity<List<ContentDTO>> findAllContents() throws Exception{
        return ResponseEntity.ok(contentService.findAllContents());
    }

    @GetMapping("/content/get/id/{id}")
    public ResponseEntity<ContentDTO> findContentById(@PathVariable String id) throws Exception{
        ContentDTO contentDTO = contentService.findContentById(id);
        if (contentDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contentDTO);
    }

    @DeleteMapping("/content/delete/{id}")
    public ResponseEntity<Boolean> deleteContentById(@PathVariable String id) throws Exception{
        return ResponseEntity.ok(contentService.deleteContentById(id));
    }

//    @PutMapping("/content/update/{id}")
//    public ResponseEntity<ContentDTO> updateContent(@PathVariable(value = "id") String id,@RequestBody ContentDTO contentDTO){
//        return ResponseEntity.ok((contentService.updateContent(contentDTO)));
//    }

}
