package com.enotes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	
	private Long id ;
	
	
	private String firtName;
	
	private String lastName;
	
	private String email ;
	
	private String password ;
	
	@OneToMany(mappedBy ="user")
	private List<Category> category ;
	
	
	
	
	
	

}
