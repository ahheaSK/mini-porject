package com.makara.mini.project.mapper;

import com.makara.mini.project.entity.Brand;
import com.makara.mini.project.request.BrandRequest;
import com.makara.mini.project.response.BrandResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-15T22:07:21+0700",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.37.0.v20240215-1558, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class BrandMapperImpl implements BrandMapper {

    @Override
    public Brand toEntity(BrandRequest request) {
        if ( request == null ) {
            return null;
        }

        Brand brand = new Brand();

        brand.setName( request.getName() );

        return brand;
    }

    @Override
    public BrandResponse toDTO(Brand entity) {
        if ( entity == null ) {
            return null;
        }

        BrandResponse brandResponse = new BrandResponse();

        if ( entity.getId() != null ) {
            brandResponse.setId( entity.getId().intValue() );
        }
        brandResponse.setName( entity.getName() );

        return brandResponse;
    }
}
