package com.enotes.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
	
	  @Id
	    @GeneratedValue
	    private Long id;

	    private String firstName;

	    private String lastName;

	    private String email;

	    private String userName;

	    private String password;
	   

	    @OneToMany(mappedBy = "user")
	    private List<Category> category;
	
	
	
	
	
	

}
