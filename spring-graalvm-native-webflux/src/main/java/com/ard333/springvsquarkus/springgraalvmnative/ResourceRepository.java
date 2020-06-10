package com.ard333.springvsquarkus.springgraalvmnative;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

	List<Resource> findByResourceString(String resourceString);

	Page<Resource> findAll(Pageable pageable);
}
