package com.example.sbdocker.testdoubles;

import com.example.sbdocker.domain.model.resource.SearchResponseResource;
import com.example.sbdocker.infrastructure.mapper.SearchMapperXml;

import java.util.List;

public class FakeSearchMapperXml implements SearchMapperXml {

    private final List<SearchResponseResource> result;
    private String lastName;
    private String lastUnitName;

    public FakeSearchMapperXml(List<SearchResponseResource> result) {
        this.result = result;
    }

    @Override
    public List<SearchResponseResource> selectProfiles(String name, String unitName) {
        this.lastName = name;
        this.lastUnitName = unitName;
        return result;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastUnitName() {
        return lastUnitName;
    }
}
