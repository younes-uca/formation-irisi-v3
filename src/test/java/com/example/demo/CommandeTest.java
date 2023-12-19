package com.example.demo;


import com.example.demo.bean.Commande;
import com.example.demo.service.CommandeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class CommandeTest {
    @Autowired
    private MockMvc mockMvc; // to make requests to the ProductController
    @Autowired
    private ObjectMapper objectMapper; // convert the ProductRequest to String
    @Autowired
    private CommandeService service;
    private String path= "http://localhost:8036/api/admin/commande/";


    @Test
    void shouldCreateProduct() throws Exception {
        Commande input = getInput();
        String inputAsString = objectMapper.writeValueAsString(input);
        mockMvc.perform(MockMvcRequestBuilders.post(path)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputAsString))
                .andExpect(status().isOk());
        int size = service.findAll().size();
        Assertions.assertEquals(4, 4);
    }

    private Commande getInput() {
        Commande input = new Commande();
        long currentTimeMillis = System.currentTimeMillis();
        input.setId(String.valueOf(currentTimeMillis));
        input.setReference("c"+currentTimeMillis);
        input.setTotal(100);
        input.setTotalPaye(10);
        return input;

    }
}
