package com.example.sbdocker.controller;

import com.example.sbdocker.domain.model.repository.SearchRepository;
import com.example.sbdocker.domain.model.resource.SearchResponseResource;
import com.example.sbdocker.domain.service.SearchService;
import com.example.sbdocker.testdoubles.FakeSearchMapperXml;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        classes = SearchControllerTest.TestApp.class,
        properties = {
                "spring.autoconfigure.exclude=" +
                        "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration," +
                        "org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration"
        }
)
class SearchControllerTest {

    private static final List<SearchResponseResource> FIXTURE = List.of(
            SearchResponseResource.builder().name("A").unitName("U1").build(),
            SearchResponseResource.builder().name("B").unitName("U2").build()
    );

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void getProfiles_returnsServiceResult() throws Exception {
        mockMvc.perform(get("/search")
                        .param("name", "name")
                        .param("unitName", "unit"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("A"))
                .andExpect(jsonPath("$[0].unitName").value("U1"))
                .andExpect(jsonPath("$[1].name").value("B"))
                .andExpect(jsonPath("$[1].unitName").value("U2"));
    }

    @SpringBootConfiguration
    @EnableAutoConfiguration
    @ComponentScan(basePackageClasses = SearchController.class)
    static class TestApp {

        @Bean
        SearchService searchService() {
            FakeSearchMapperXml mapper = new FakeSearchMapperXml(FIXTURE);
            SearchRepository repository = new SearchRepository(mapper);
            return new SearchService(repository);
        }
    }
}
