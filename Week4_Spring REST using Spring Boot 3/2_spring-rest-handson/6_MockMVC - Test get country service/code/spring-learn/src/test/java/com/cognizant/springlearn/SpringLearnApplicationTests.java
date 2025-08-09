package com.cognizant.springlearn;

import com.cognizant.springlearn.controller.CountryController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {

    @Autowired
    private CountryController countryController;

    @Autowired
    private MockMvc mvc;

    @Test
    public void contextLoads() {
        assertNotNull(countryController); // ✅ Check controller is loaded
    }

    @Test
    public void testGetCountry() throws Exception {
        ResultActions actions = mvc.perform(get("/country"));  // ⬅️ Call endpoint
        actions.andExpect(status().isOk());                    // ✅ Check status 200
        actions.andExpect(jsonPath("$.code").exists());        // ✅ Check "code" field
        actions.andExpect(jsonPath("$.code").value("IN"));     // ✅ Check value is "IN"
        actions.andExpect(jsonPath("$.name").exists());        // ✅ Check "name" field
        actions.andExpect(jsonPath("$.name").value("India"));  // ✅ Check value is "India"
    }
}
