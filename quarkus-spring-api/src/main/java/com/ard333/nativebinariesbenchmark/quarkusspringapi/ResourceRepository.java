package com.ard333.nativebinariesbenchmark.quarkusspringapi;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

	List<Resource> findByResourceString(String resourceString, Pageable pageable);

	Page<Resource> findAll(Pageable pageable);

}