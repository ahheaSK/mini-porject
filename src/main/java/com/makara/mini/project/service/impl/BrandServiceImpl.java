package com.makara.mini.project.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.makara.mini.project.entity.Brand;
import com.makara.mini.project.exception.ResourceNotFoundException;
import com.makara.mini.project.mapper.BrandMapper;
import com.makara.mini.project.repository.BrandReposiory;
import com.makara.mini.project.response.BrandResponse;
import com.makara.mini.project.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandReposiory brandReposiory;
	
	@Autowired
	private BrandMapper itemBrandMapper;

	@Override
	public Brand saveData(Brand brand) {
		return brandReposiory.save(brand);
	}

	@Override
	public Brand getById(Long id) {
		return brandReposiory.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Brands", id));
	}

	@Override
	public Brand update(Long id, Brand update) {
		// TODO Auto-generated method stub
		Brand dataUpdate = getById(id);
		dataUpdate.setName(update.getName());
		
		return brandReposiory.save(dataUpdate);
	}

	@Override
	public List<BrandResponse> listAll() {
		// TODO Auto-generated method stub
		return brandReposiory.findAll().stream().map(itemBrandMapper::toDTO).collect(Collectors.toList());
	}

	@Override
	public Brand deleteById(Long id) {
		// TODO Auto-generated method stub
		Brand byId = getById(id);
		brandReposiory.delete(byId);
		return byId;
	}

}
