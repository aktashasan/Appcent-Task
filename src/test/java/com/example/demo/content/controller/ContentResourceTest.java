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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    void addContent() throws Exception{
        contentRepository.deleteAll();
        ContentDTO contentDTO = new ContentBuilder()
                .buildSomeDummy()
                .build();

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
    void deleteContentById() throws Exception {
        ContentDTO contentDTO = new ContentBuilder()
                .buildSomeDummy()
                .build();

        ContentDTO savedContent = contentService.addContent(contentDTO);

        ResultActions resultActions = this.mockMvc
                .perform(get("/app/content/delete/" + savedContent.getId()))
                .andDo(print())
                .andExpect(status().isOk());

        MvcResult mvcResult = resultActions.andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();

        Boolean result = objectMapper.readValue(contentAsString, Boolean.class);
        Assertions.assertEquals(Boolean.TRUE,result);
    }
}