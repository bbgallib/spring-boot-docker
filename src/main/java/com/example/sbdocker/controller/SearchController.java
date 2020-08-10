package com.example.sbdocker.controller;

import com.example.sbdocker.domain.model.resource.SearchResponseResource;
import com.example.sbdocker.domain.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping(value = "/search")
    public List<SearchResponseResource> getProfiles(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "unitName", required = false) String unitName
    ) {
        List<SearchResponseResource> resources = searchService.selectProfiles(name, unitName);
        System.out.println(resources);
        return resources;
    }
}
