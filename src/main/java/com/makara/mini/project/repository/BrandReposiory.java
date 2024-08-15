package com.makara.mini.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.makara.mini.project.entity.Brand;

@Repository
public interface BrandReposiory extends JpaRepository<Brand, Long> {


}
