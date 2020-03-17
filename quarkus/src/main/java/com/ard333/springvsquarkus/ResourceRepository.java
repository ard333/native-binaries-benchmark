package com.ard333.springvsquarkus;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;

@ApplicationScoped
public class ResourceRepository implements PanacheRepository<Resource> {

	public List<Resource> findByResourceString(String resourceString){
		return list("resourceString", resourceString);
	}

	public List<Resource> findByPage(Integer page, Integer size){
		return findAll().page(Page.of(page, size)).list();
	}
	
}