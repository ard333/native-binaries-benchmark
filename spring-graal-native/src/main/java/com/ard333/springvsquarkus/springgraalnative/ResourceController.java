package com.ard333.springvsquarkus.springgraalnative;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private ResourceRepository resourceRepository;

	public ResourceController(ResourceRepository resourceRepository) {
		this.resourceRepository = resourceRepository;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(resourceRepository.findById(id));
	}

	@GetMapping("/by-page/{page}/{size}")
	public ResponseEntity<?> findByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		return ResponseEntity.ok(resourceRepository.findAll(PageRequest.of(page - 1, size)));
	}

	@GetMapping("/by-resource-string/{resourceString}")
	public ResponseEntity<?> findByRe(@PathVariable("resourceString") String resourceString) {
		return ResponseEntity.ok(resourceRepository.findByResourceString(resourceString));
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Resource resource) {
		resourceRepository.save(resource);
		return ResponseEntity.ok().build();
	}

	// @PutMapping("/{id}") //405 if using this
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Resource resource) {
		Optional<Resource> r = resourceRepository.findById(id);
		if (r.isPresent()) {
			r.get().setResourceString(resource.getResourceString());
			r.get().setResourceText(resource.getResourceText());
			resourceRepository.save(r.get());
		}
		return ResponseEntity.ok().build();
	}

}
