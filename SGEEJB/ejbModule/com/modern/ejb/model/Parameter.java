package com.modern.ejb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_PARAMETER", schema="GENERAL")
public class Parameter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4479690437360779041L;

	@Id
	@Column(name="ID_PARAMETER")
	private Long id;
	
	@Column(nullable=false, length=50)
	private String description;
	
	@Column(updatable=false)
	private Integer type;
	
	private Integer value;
	private boolean active;
	
	public Parameter(){}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
