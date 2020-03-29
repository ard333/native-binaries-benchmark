package app.main;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.main.model.Foo;
import app.main.model.FooRepository;

@RestController
@RequestMapping("/resource")
public class ResourceController {

        private FooRepository resourceRepository;

        public ResourceController(FooRepository resourceRepository) {
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
        public void create(@RequestBody Foo resource) {
                resourceRepository.save(resource);
        }

        //@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	@PutMapping("/{id}")
        public void update(@PathVariable("id") Long id, @RequestBody Foo resource) {
                Optional<Foo> r = resourceRepository.findById(id);
                if (r.isPresent()) {
                        r.get().setResourceString(resource.getResourceString());
                        r.get().setResourceText(resource.getResourceText());
                        resourceRepository.save(r.get());
                }
        }

}
