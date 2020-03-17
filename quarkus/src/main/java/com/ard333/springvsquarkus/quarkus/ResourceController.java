package com.ard333.springvsquarkus.quarkus;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/resource")
public class ResourceController {

	@Inject
	private ResourceService resourceService;

	@GET() @Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Resource findById(@PathParam("id") Long id) {
		return resourceService.findById(id);
	}

	@GET() @Path("/by-page/{page}/{size}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resource> findByPage(@PathParam("page") Integer page, @PathParam("size") Integer size) {
		return resourceService.findByPage(page, size);
	}

	@GET() @Path("/by-resource-string/{resourceString}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resource> findByRe(@PathParam("resourceString") String resourceString) {
		return resourceService.findByResourceString(resourceString);
	}

	@POST()
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Resource resource) {
		resourceService.create(resource);
	}

	@PUT() @Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(@PathParam("id") Long id, Resource resource) {
		resourceService.update(id, resource);
	}
}