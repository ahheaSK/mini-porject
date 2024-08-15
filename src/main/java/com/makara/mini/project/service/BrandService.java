package com.makara.mini.project.service;

import java.util.List;

import com.makara.mini.project.entity.Brand;
import com.makara.mini.project.response.BrandResponse;

public interface BrandService {
	Brand saveData(Brand brand);
	
	Brand getById(Long id);
	
	Brand update(Long id, Brand update);
	
	List<BrandResponse> listAll();
	
	Brand deleteById(Long id);
}
