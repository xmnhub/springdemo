package com.example.demo;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        System.out.println("hello world");
        String allo = "{\n" +
                "  \"userName\": \"hekko\",\n" +
                "  \"password\": \"123456\",\n" +
                "  \"email\": \"hekko@gmail.com\",\n" +
                "  \"phone\": \"1234567890\",\n" +
                "  \"address\": \"Beijing\",\n" +
                "  \"hobbies\": [\n" +
                "    \"basketball\",\n" +
                "    \"football\",\n" +
                "    \"swimming\"\n" +
                "  ],\n" +
                "  \"roles\": [\n" +
                "    {\n" +
                "      \"roleId\": 1,\n" +
                "      \"roleName\": \"ROLE_ADMIN\",\n" +
                "      \"roleDesc\": \"超级管理员\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"roleId\": 2,\n" +
                "      \"roleName\": \"ROLE_USER\",\n" +
                "      \"roleDesc\": \"普通用户\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/users/{id}", 1)
                                .accept(MediaType.APPLICATION_JSON_VALUE)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(allo)
                ).andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("zhangsan18"))
                .andDo(MockMvcResultHandlers.print());
    }
}
