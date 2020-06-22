package com.ard333.nativebinariesbenchmark.quarkus;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;

@ApplicationScoped
public class ResourceRepository implements PanacheRepository<Resource> {

	public List<Resource> findByResourceString(String resourceString, Integer page, Integer size){
		return find("resourceString", resourceString).page(Page.of(page, size)).list();
	}

	public List<Resource> findByPage(Integer page, Integer size){
		return findAll().page(Page.of(page, size)).list();
	}
	
}