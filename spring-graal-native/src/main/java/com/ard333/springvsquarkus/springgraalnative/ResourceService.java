package com.ard333.springvsquarkus.springgraalnative;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResourceService {

	@Autowired
	private ResourceRepository resourceRepository; 

	public Optional<Resource> findById(Long id) {
		return resourceRepository.findById(id);
	}

	public Page<Resource> findByPage(Integer page, Integer size) {
		return resourceRepository.findAll(PageRequest.of(page - 1, size));
	}

	public List<Resource> findByResourceString(String resourceString) {
		return resourceRepository.findByResourceString(resourceString);
	}

	@Transactional
	public void create(Resource resource) {
		resourceRepository.save(resource);
	}

	@Transactional
	public void update(Long id, Resource resource) {
		Optional<Resource> r = resourceRepository.findById(id);
		if (r.isPresent()) {
			r.get().setResourceString(resource.getResourceString());
			r.get().setResourceText(resource.getResourceText());
			resourceRepository.save(r.get());
		}
	}
}