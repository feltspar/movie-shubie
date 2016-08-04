package io.egen.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Cast {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String castId;
	
	private String name;
	private String type; //actor, director, writer	
	
	public String getCastId() {
		return castId;
	}


	public void setCastId(String castId) {
		this.castId = castId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Cast [castId=" + castId + ", name=" + name + ", type=" + type + "]";
	}
	
}
