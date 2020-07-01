package com.ard333.nativebinariesbenchmark.springboot;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Resource> findByPage(Integer page, Integer size) {
		return resourceRepository.findAll(PageRequest.of(page - 1, size)).getContent();
	}

	public List<Resource> findByResourceString(String resourceString, Integer page, Integer size) {
		return resourceRepository.findByResourceString(resourceString, PageRequest.of(page - 1, size));
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

	@Transactional
	public void delete(Long id) {
		if (resourceRepository.existsById(id)) resourceRepository.deleteById(id);
	}
	
}
