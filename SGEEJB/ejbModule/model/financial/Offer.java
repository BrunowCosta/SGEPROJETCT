package model.financial;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.User;

@Entity
@Table(name="T_OFFER", schema="FINANCIAL")
@SequenceGenerator(name="SEQ_ID_OFFER", sequenceName="SEQ_ID_OFFER", schema="FINANCIAL")
public class Offer  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 916387539858248864L;

	@Id
	@Column(name="ID_OFFER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_OFFER")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="FK_CREATOR")
	private User creator;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false, updatable=false)
	private Calendar createDate;
	
	@ManyToOne
	@JoinColumn(name="FK_LASTUPDATER")
	private User lastUpdater;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar lastUpdateDate;
	
	private Double value;
	
	@Column(nullable=false)
	private String description;
	
	public Offer(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	public User getLastUpdater() {
		return lastUpdater;
	}

	public void setLastUpdater(User lastUpdater) {
		this.lastUpdater = lastUpdater;
	}

	public Calendar getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Calendar lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
