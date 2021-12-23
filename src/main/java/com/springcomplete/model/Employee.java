package com.springcomplete.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//TO avoid boilerPlate Code (getters and setters , constructors) we are using @Data annotation
@Data

//It is used to say that the defined class is an entity
//It will check for @Table annotation or else by default it will use className as tableName
@Entity

//Used to specify the table name in our database. If we failed to write @Entity will take className as tablename
@Table(name="employees")
public class Employee {
		
	//It is used to specify the Primary Key
	@Id
	private Integer id;
	
	
	//@Column is used to specify the column name in the table
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
}
