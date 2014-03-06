package model.financial;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import model.User;

@Entity
@Table(name="T_SCHEDULEDOUTFLOW", schema="FINANCIAL")
@SequenceGenerator(name="SEQ_ID_SCHEDULEDOUTFLOW", sequenceName="SEQ_ID_SCHEDULEDOUTFLOW", schema="FINANCIAL")
public class ScheduledOutflow implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5235781156838574592L;

	@Id
	@Column(name="ID_SHEDULEDOUTFLOW")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_SCHEDULEDOUTFLOW")
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
	
	//TODO Escrever as constraints.
	private Integer periodicity;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Calendar startDate;
	
	@Temporal(TemporalType.DATE)
	private Calendar endDate;
	
	private Double standartValue;
	
	private boolean active;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="FK_COSTCENTER")
	private CostCenter costCenter;
	
	@OneToMany(cascade=CascadeType.REFRESH)
	private List<CapitalOutflow> generatedOutflows;
	
	public ScheduledOutflow(){}
	
	public ScheduledOutflow(Long id, Integer periodicity, Calendar startDate, Double standartValue) {
		this.id = id;
		this.periodicity = periodicity;
		this.startDate = startDate;
		this.standartValue = standartValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Integer periodicity) {
		this.periodicity = periodicity;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public Double getStandartValue() {
		return standartValue;
	}

	public void setStandartValue(Double standartValue) {
		this.standartValue = standartValue;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	public List<CapitalOutflow> getGeneratedOutflows() {
		return generatedOutflows;
	}

	public void setGeneratedExpenses(List<CapitalOutflow> generatedOutflows) {
		this.generatedOutflows = generatedOutflows;
	}
	
}
