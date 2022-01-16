package com.raminzare.demo.warehouse;

import com.raminzare.demo.warehouse.service.api.WarehouseRestAPI;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class WarehouseRestAPIIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getById_returnObject_withStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/warehouse/101")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("id", Matchers.is(101)))
                .andExpect(MockMvcResultMatchers.jsonPath("name", Matchers.is("Mid-America Warehouse")));
    }

    @Test
    void getById_warehouseNotFound_withStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/warehouse/888888")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("message", Matchers.is("WarehouseNotFoundException")));
    }

}
