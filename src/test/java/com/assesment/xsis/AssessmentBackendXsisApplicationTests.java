package com.assesment.xsis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AssessmentBackendXsisApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testingGetAll() throws Exception {
		this.mockMvc.perform(get("/Movies").accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$", hasSize(1)))
		.andExpect(jsonPath("$[0]").isMap())
		.andExpect(jsonPath("$[0].id").isNumber())
		.andExpect(jsonPath("$[0].title").isString())
		.andExpect(jsonPath("$[0].description").isString())
		.andExpect(jsonPath("$[0].rating", is(8.0)))
		.andExpect(jsonPath("$[0].rating").isNumber())
		.andExpect(jsonPath("$[0].image").exists())
		.andExpect(jsonPath("$[0].created_at").exists())
		.andExpect(jsonPath("$[0].updated_at").exists());
	}

	@Test
	void testingGetById() throws Exception {
		this.mockMvc.perform(get("/Movies/502").accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").isNumber())
		.andExpect(jsonPath("$.title").isString())
		.andExpect(jsonPath("$.description").isString())
		.andExpect(jsonPath("$.rating", is(8.0)))
		.andExpect(jsonPath("$.rating").isNumber())
		.andExpect(jsonPath("$.image").exists())
		.andExpect(jsonPath("$.created_at").exists())
		.andExpect(jsonPath("$.updated_at").exists());
	}

	@Test
	void testingDeleteById() throws Exception {
		this.mockMvc.perform(delete("/Movies/502").accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk());
	}
}
