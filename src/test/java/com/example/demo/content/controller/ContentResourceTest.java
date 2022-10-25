package com.example.demo.content.controller;

import com.example.demo.builder.content.ContentBuilder;
import com.example.demo.content.model.ContentDTO;
import com.example.demo.content.repository.ContentRepository;
import com.example.demo.content.service.ContentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureDataMongo
@AutoConfigureMockMvc
class ContentResourceTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContentService contentService;

    @Autowired
    private ContentRepository contentRepository;


    @Test
    @WithMockUser(username = "admin", password = "admin")
    void addContent() throws Exception{
        ContentDTO contentDTO = new ContentBuilder()
                .buildSomeDummy()
                .build();
        ContentDTO savedContent = contentService.addContent(contentDTO);

        String jsonContent = objectMapper.writeValueAsString(contentDTO);

        ResultActions resultActions = this.mockMvc
                .perform(post("/app/content/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andDo(print())
                .andExpect(status().isOk());
        MvcResult mvcResult = resultActions .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();

        ContentDTO result = objectMapper.readValue(contentAsString, ContentDTO.class);
        Assertions.assertNotNull(result.getId());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin")
    void findContentById() throws Exception{
        ContentDTO contentDTO = new ContentBuilder()
                .buildSomeDummy()
                .build();

        ContentDTO savedContent = contentService.addContent(contentDTO);

        ResultActions resultActions = this.mockMvc
                .perform(get("/app/content/get/id/" + savedContent.getId()))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult mvcResult = resultActions.andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();

        ContentDTO result = objectMapper.readValue(contentAsString, ContentDTO.class);
        Assertions.assertEquals(savedContent.getId(), result.getId());


    }

    @Test
    @WithMockUser(username = "admin", password = "admin")
    void deleteContentById() throws Exception {
        ContentDTO contentDTO = new ContentBuilder()
                .buildSomeDummy()
                .build();

        ContentDTO savedContent = contentService.addContent(contentDTO);

        ResultActions resultActions = this.mockMvc
                .perform(delete("/app/content/delete/" + savedContent.getId()))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult mvcResult = resultActions.andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();

        Boolean result = objectMapper.readValue(contentAsString, Boolean.class);
        Assertions.assertEquals(Boolean.TRUE,result);
    }

    @Test
    @WithMockUser(username = "admin", password = "admin")
    void findAllContents() throws Exception {
        contentRepository.deleteAll();
        ContentDTO contentDTO = new ContentBuilder()
                .buildSomeDummy()
                .build();
        ContentDTO savedContent = contentService.addContent(contentDTO);

        ResultActions resultActions = this.mockMvc
                .perform(get("/app/contents/get/"))
                .andDo(print())
                .andExpect(status().isOk());
        MvcResult mvcResult = resultActions.andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();

        List<ContentDTO> result = objectMapper.readValue(contentAsString, List.class);
        Assertions.assertEquals(1,result.size());


    }

//    @Test
//    @WithMockUser(username = "admin", password = "admin")
//    void updateContent() throws Exception{
//        ContentDTO contentDTO = new ContentBuilder()
//                .buildSomeDummy()
//                .build();
//        ContentDTO savedContent = contentService.addContent(contentDTO);
//
//        ContentDTO resultContent = contentService.updateContent(savedContent.getId(), "sdhf","ahsd","sdfha","sjdkf");
//
//
//        ResultActions resultActions = this.mockMvc
//                .perform(get("/app/content/update/" + savedContent.getId())
//                .andDo(print())
//                .andExpect(status().isOk());
//        MvcResult mvcResult = resultActions.andReturn();
//        String contentAsString = mvcResult.getResponse().getContentAsString();
//
//        ContentDTO result = objectMapper.readValue(contentAsString, ContentDTO.class);
//        System.out.println(result);
//        Assertions.assertNotEquals(savedContent,result);
//    }
}