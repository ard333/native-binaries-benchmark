package com.ard333.springvsquarkus.springgraalnative;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "resource", schema = "public")
public class Resource implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "resource_text")
	private String resourceText;

	@Column(name = "resource_string")
	private String resourceString;

	public Resource() {
	}

	public Resource(Long id, String resourceText, String resourceString) {
		this.id = id;
		this.resourceText = resourceText;
		this.resourceString = resourceString;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResourceText() {
		return resourceText;
	}

	public void setResourceText(String resourceText) {
		this.resourceText = resourceText;
	}

	public String getResourceString() {
		return resourceString;
	}

	public void setResourceString(String resourceString) {
		this.resourceString = resourceString;
	}
}
