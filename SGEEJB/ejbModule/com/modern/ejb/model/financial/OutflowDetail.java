package com.modern.ejb.model.financial;

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

@Entity
@Table(name="T_OUTFLOWDETAIL", schema="FINANCIAL")
@SequenceGenerator(name="SEQ_ID_OUTFLOWDETAIL", sequenceName="SEQ_ID_OUTFLOWDETAIL", schema="FINANCIAL")
public class OutflowDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 363086694759032723L;

	@Id
	@Column(name="ID_OUTFLOWDETAIL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_OUTFLOWDETAIL")
	private Long id;
	
	//TODO Definir constrains entrada e parcelas.
	private Integer type;
	
	@Temporal(TemporalType.DATE)
	private Calendar billingDate;
	
	@Temporal(TemporalType.DATE)
	private Calendar expirationDate;
	
	@Temporal(TemporalType.DATE)
	private Calendar paymentDate;
	
	private Double value;
	
	private boolean paid;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="FK_CAPITALOUTFLOW")
	private CapitalOutflow capitalOutflow;
	
	public OutflowDetail(){}
	
	public OutflowDetail(Integer type, Calendar billingDate, Double value, boolean paid) {
		this.type = type;
		this.billingDate = billingDate;
		this.value = value;
		this.paid = paid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Calendar getBillingDate() {
		return billingDate;
	}

	public void setBillingDate(Calendar billingDate) {
		this.billingDate = billingDate;
	}

	public Calendar getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Calendar expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Calendar getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Calendar paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public CapitalOutflow getCapitalOutflow() {
		return capitalOutflow;
	}

	public void setCapitalOutflow(CapitalOutflow capitalOutflow) {
		this.capitalOutflow = capitalOutflow;
	}
	
}
