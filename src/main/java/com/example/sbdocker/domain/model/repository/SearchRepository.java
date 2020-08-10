package com.example.sbdocker.domain.model.repository;

import com.example.sbdocker.domain.model.resource.SearchResponseResource;
import com.example.sbdocker.infrastructure.mapper.SearchMapperXml;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchRepository {

    private final SearchMapperXml searchMapperXml;

    public List<SearchResponseResource> selectProfiles(String name, String unitName) {
        return searchMapperXml.selectProfiles(name, unitName);
    }
}
