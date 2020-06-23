package com.ard333.nativebinariesbenchmark.quarkus;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/resource")
public class ResourceController {

	@Inject
	private ResourceService resourceService;

	@GET() @Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Resource findById(@PathParam("id") Long id) {
		return resourceService.findById(id);
	}

	@GET() @Path("/page/{page}/{size}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resource> findByPage(@PathParam("page") Integer page, @PathParam("size") Integer size) {
		return resourceService.findByPage(page, size);
	}

	@GET() @Path("/resource-string/{resourceString}/page/{page}/{size}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resource> findByRe(@PathParam("resourceString") String resourceString, @PathParam("page") Integer page, @PathParam("size") Integer size) {
		return resourceService.findByResourceString(resourceString, page, size);
	}

	@POST()
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Resource resource) {
		resourceService.create(resource);
		return Response.ok().build();
	}

	@PUT() @Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, Resource resource) {
		resourceService.update(id, resource);
		return Response.ok().build();
	}

	@DELETE() @Path("/{id}")
	public Response delete(@PathParam("id") Long id) {
		resourceService.delete(id);
		return Response.ok().build();
	}
}