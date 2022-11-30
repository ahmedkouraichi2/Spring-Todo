package com.enotes.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todos implements Serializable {
	@Id
	@GeneratedValue
	private Long id ;
	private String title;
	private String description;
	private ZonedDateTime startTime;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	@JsonIgnore
	private Category category;
	
	
	
	

}
