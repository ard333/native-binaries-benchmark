package com.ard333.springvsquarkus;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class ResourceService {

	@Inject
	private ResourceRepository resourceRepository; 

	public Resource findById(Long id) {
		return resourceRepository.findById(id);
	}

	public List<Resource> findByPage(Integer page, Integer size) {
		return resourceRepository.findByPage(page - 1, size);
	}

	public List<Resource> findByResourceString(String resourceString) {
		System.out.println(resourceString);
		return resourceRepository.findByResourceString(resourceString);
	}

	@Transactional
	public void create(Resource resource) {
		resourceRepository.persist(resource);
	}

}