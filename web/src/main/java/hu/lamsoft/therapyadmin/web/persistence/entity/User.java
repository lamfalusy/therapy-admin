package hu.lamsoft.therapyadmin.web.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

	private Integer id;
	private String name;
	private String password;
	
}
