package com.example.sbdocker.infrastructure.mapper;

import com.example.sbdocker.domain.model.resource.SearchResponseResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchMapperXml {
    List<SearchResponseResource> selectProfiles(@Param("name") String name, @Param("unitName") String unitName);
}
