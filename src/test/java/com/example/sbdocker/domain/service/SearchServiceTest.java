package com.example.sbdocker.domain.service;

import com.example.sbdocker.domain.model.repository.SearchRepository;
import com.example.sbdocker.domain.model.resource.SearchResponseResource;
import com.example.sbdocker.testdoubles.FakeSearchMapperXml;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchServiceTest {

    @Test
    void selectProfiles_delegatesToRepositoryAndReturnsResult() {
        List<SearchResponseResource> expected = List.of(
                SearchResponseResource.builder().name("A").unitName("U1").build()
        );
        FakeSearchMapperXml mapper = new FakeSearchMapperXml(expected);
        SearchRepository repository = new SearchRepository(mapper);
        SearchService service = new SearchService(repository);

        List<SearchResponseResource> actual = service.selectProfiles("name", "unit");

        assertSame(expected, actual);
        assertEquals("name", mapper.getLastName());
        assertEquals("unit", mapper.getLastUnitName());
    }
}
