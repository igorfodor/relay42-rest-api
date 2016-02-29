package com.relay42.web.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by teknik on 21-2-16.
 */


@WebAppConfiguration
@ContextConfiguration(locations= {"/applicationContext-servlet.xml", "/spring-core-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TomatoControllerTest {
    private static final String ENDPOINT = "/tomatoes/data";

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getSmallListOfTomatoes_should_return_json() throws Exception {
        this.mockMvc.perform(get(ENDPOINT).accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

    }

    @Test
    public void invalidSizeParameter_ShouldReturn400() throws Exception {


        mockMvc.perform(get(ENDPOINT +"?size=" + 1001))
                .andExpect(status().isBadRequest());


    }
}
