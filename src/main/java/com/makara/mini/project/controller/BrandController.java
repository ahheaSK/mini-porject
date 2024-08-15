package com.makara.mini.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.makara.mini.project.entity.Brand;
import com.makara.mini.project.mapper.BrandMapper;
import com.makara.mini.project.request.BrandRequest;
import com.makara.mini.project.response.BrandResponse;
import com.makara.mini.project.service.BrandService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("brands")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private BrandMapper itemBrandMapper;
	
	@PostMapping
	public ResponseEntity<BrandResponse> saveData(@Valid @RequestBody BrandRequest dto){
		
		Brand brand = itemBrandMapper.toEntity(dto);
		Brand saveData = brandService.saveData(brand);

		BrandResponse response = itemBrandMapper.toDTO(saveData);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<BrandResponse> getById(@PathVariable Long id){
		Brand getData = brandService.getById(id);
		BrandResponse response = itemBrandMapper.toDTO(getData);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<BrandResponse> update(@PathVariable Long id, @Valid @RequestBody BrandRequest request){
		
		Brand brand = itemBrandMapper.toEntity(request);
		Brand update = brandService.update(id, brand);
		BrandResponse response = itemBrandMapper.toDTO(update);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<List<BrandResponse>> getAllEntity(){
		List<BrandResponse> responses = brandService.listAll();
		return ResponseEntity.ok(responses);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Brand deleteById = brandService.deleteById(id);
		BrandResponse response = itemBrandMapper.toDTO(deleteById);
		return ResponseEntity.ok(response);
	}
	

}
