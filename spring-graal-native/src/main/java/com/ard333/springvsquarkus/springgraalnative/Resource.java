package com.ard333.springvsquarkus.springgraalnative;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resource", schema = "public")
@AllArgsConstructor @NoArgsConstructor @Data
public class Resource {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "resource_text")
	private String resourceText;

	@Column(name = "resource_string")
	private String resourceString;

}
