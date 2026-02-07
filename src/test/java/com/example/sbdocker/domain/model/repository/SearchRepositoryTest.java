package com.example.sbdocker.domain.model.repository;

import com.example.sbdocker.domain.model.resource.SearchResponseResource;
import com.example.sbdocker.testdoubles.FakeSearchMapperXml;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchRepositoryTest {

    @Test
    void selectProfiles_delegatesToMapperAndReturnsResult() {
        List<SearchResponseResource> expected = List.of(
                SearchResponseResource.builder().name("A").unitName("U1").build(),
                SearchResponseResource.builder().name("B").unitName("U2").build()
        );
        FakeSearchMapperXml mapper = new FakeSearchMapperXml(expected);
        SearchRepository repository = new SearchRepository(mapper);

        List<SearchResponseResource> actual = repository.selectProfiles("name", "unit");

        assertSame(expected, actual);
        assertEquals("name", mapper.getLastName());
        assertEquals("unit", mapper.getLastUnitName());
    }
}
