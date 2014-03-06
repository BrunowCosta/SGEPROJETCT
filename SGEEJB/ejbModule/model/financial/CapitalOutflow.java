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
@Table(name="T_CAPITALOUTFLOW", schema="FINANCIAL")
@SequenceGenerator(name="SEQ_ID_CAPITALOUTFLOW", sequenceName="SEQ_ID_CAPITALOUTFLOW", schema="FINANCIAL")
public class CapitalOutflow implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -628011814159142478L;
	
	@Id
	@Column(name="ID_CAPITALOUTFLOW")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_CAPITALOUTFLOW")
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
	
	private Double totalValue;
	
	//TODO Permitir que o usuário importe um imagem de uma nota fiscal.
	private String invoice;
	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="FK_COSTCENTER")
	private CostCenter costCenter;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<OutflowDetail> outflowDetails;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Patrimony> acquiredPatrimonies;

	public CapitalOutflow() {}

	public CapitalOutflow(String description, Double totalValue, CostCenter costCenter) {
		this.description = description;
		this.totalValue = totalValue;
		this.costCenter = costCenter;
	}

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

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public CostCenter getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}

	public List<OutflowDetail> getExpenseEntries() {
		return outflowDetails;
	}

	public void setExpenseEntries(List<OutflowDetail> outflowDetails) {
		this.outflowDetails = outflowDetails;
	}

	public List<Patrimony> getAcquiredPatrimonies() {
		return acquiredPatrimonies;
	}

	public void setAcquiredPatrimonies(List<Patrimony> acquiredPatrimonies) {
		this.acquiredPatrimonies = acquiredPatrimonies;
	}

}
