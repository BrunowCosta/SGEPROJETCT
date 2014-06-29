package com.modern.ejb.model.financial;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_COSTCENTER", schema="FINANCIAL")
@SequenceGenerator(name="SEQ_ID_COSTCENTER", sequenceName="SEQ_ID_COSTCENTER", schema="FINANCIAL")
public class CostCenter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5458339694500984471L;

	@Id
	@Column(name="ID_COSTCENTER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_COSTCENTER")
	private Long id;
	
	@Column(nullable=false)
	private String description;
	
	private boolean active;
	
	public CostCenter(){}

	public CostCenter(Long id, String description) {
		this.id = id;
		this.description = description;
	}

	public Long getId() {
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
