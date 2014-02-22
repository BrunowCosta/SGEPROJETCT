package model.financial;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
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
@Table(name="T_PATRIMONY", schema="FINANCIAL")
@SequenceGenerator(name="SEQ_ID_PATRIMONY", sequenceName="SEQ_ID_PATRIMONY", schema="FINANCIAL")
public class Patrimony implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4142324471602457083L;

	@Id
	@Column(name="ID_PATRIMONY")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_PATRIMONY")
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
	
	@Column(nullable=false)
	private String description;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Calendar acquisitionDate;
	
	//TODO fazer as constrains.
	private Integer state;
	
	private Double value;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="FK_EXPENSE")
	private Expense Expense;
	
	public Patrimony(){}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(Calendar acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Expense getExpense() {
		return Expense;
	}

	public void setExpense(Expense expense) {
		Expense = expense;
	}
	
}
