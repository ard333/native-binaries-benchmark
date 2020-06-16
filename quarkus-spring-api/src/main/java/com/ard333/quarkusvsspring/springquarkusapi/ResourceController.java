package com.ard333.quarkusvsspring.springquarkusapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return ResponseEntity.ok(resourceService.findById(id));
	}

	@GetMapping("/by-page/{page}/{size}")
	public ResponseEntity<?> findByPage(@PathVariable Integer page, @PathVariable Integer size) {
		return ResponseEntity.ok(resourceService.findByPage(page, size));
	}

	@GetMapping("/by-resource-string/{resourceString}")
	public ResponseEntity<?> findByRe(@PathVariable String resourceString) {
		return ResponseEntity.ok(resourceService.findByResourceString(resourceString));
	}

	@PostMapping()
	public void create(@RequestBody Resource resource) {
		resourceService.create(resource);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable("id") Long id, @RequestBody Resource resource) {
		resourceService.update(id, resource);
	}
}