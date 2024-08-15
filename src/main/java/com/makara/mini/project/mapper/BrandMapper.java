package com.makara.mini.project.mapper;

import org.mapstruct.Mapper;

import com.makara.mini.project.entity.Brand;
import com.makara.mini.project.request.BrandRequest;
import com.makara.mini.project.response.BrandResponse;

@Mapper(componentModel = "spring")
public interface BrandMapper {
	
	 Brand toEntity(BrandRequest request);

	 BrandResponse toDTO(Brand entity);
}
