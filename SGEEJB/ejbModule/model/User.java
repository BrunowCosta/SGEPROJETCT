package model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_USER", schema="GENERAL")
@SequenceGenerator(name="SEQ_ID_USER", sequenceName="SEQ_ID_USER", schema="GENERAL")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5838297122899853987L;

	@Id
	@Column(name="ID_USER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_USER")
	private Long id;
	
	@Column(nullable=false, length=30)
	private String login;
	
	@Column(nullable=false, length=32)
	private String password;
	
	private Integer loginAttempt;
	private boolean active;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar blockDate;
	
	public User() {}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
		this.active = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLoginAttempt() {
		return loginAttempt;
	}
	
	public void incrementLoginAttempt() {
		this.loginAttempt =+ 1;
	}

	public Calendar getBlockDate() {
		return blockDate;
	}

	public void setBlockDate(Calendar blockDate) {
		this.blockDate = blockDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
