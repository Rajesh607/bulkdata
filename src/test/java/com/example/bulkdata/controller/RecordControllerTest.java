package com.example.bulkdata.controller;

import com.example.bulkdata.model.DataRecord;
import com.example.bulkdata.service.RecordService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RecordController.class)
@Import(RecordControllerTest.MockConfig.class)
public class RecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RecordService service;

    @Test
    public void testGetAll() throws Exception {
        List<DataRecord> records = List.of(new DataRecord(1L, "Alice", "alice@example.com", "New York"));
        Mockito.when(service.getAll()).thenReturn(records);

        mockMvc.perform(get("/api/records")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].name").value("Alice"));
    }

    @TestConfiguration
    static class MockConfig {
        @Bean
        public RecordService recordService() {
            return mock(RecordService.class);
        }
    }
}
