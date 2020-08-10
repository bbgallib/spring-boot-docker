package com.example.sbdocker.domain.service;

import com.example.sbdocker.domain.model.repository.SearchRepository;
import com.example.sbdocker.domain.model.resource.SearchResponseResource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final SearchRepository searchRepository;

    public List<SearchResponseResource> selectProfiles(String name, String unitName) {
        return searchRepository.selectProfiles(name, unitName);
    }
}
