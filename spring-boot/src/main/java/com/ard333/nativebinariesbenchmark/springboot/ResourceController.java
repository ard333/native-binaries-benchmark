package com.ard333.nativebinariesbenchmark.springboot;

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

@RestController
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(resourceService.findById(id));
	}

	@GetMapping("/page/{page}/{size}")
	public ResponseEntity<?> findByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		return ResponseEntity.ok(resourceService.findByPage(page, size));
	}

	@GetMapping("/resource-string/{resourceString}/page/{page}/{size}")
	public ResponseEntity<?> findByResourceString(@PathVariable("resourceString") String resourceString, @PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		return ResponseEntity.ok(resourceService.findByResourceString(resourceString, page, size));
	}

	@PostMapping
	public void create(@RequestBody Resource resource) {
		resourceService.create(resource);
	}

	@PutMapping("/{id}")
	public void update(@PathVariable("id") Long id, @RequestBody Resource resource) {
		resourceService.update(id, resource);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		resourceService.delete(id);
	}

}
