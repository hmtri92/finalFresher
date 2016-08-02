package com.csc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name = "roles")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	public static final int CUSTOMER = 1;
	
	@Transient
	public static final int ADMIN = 2;
	
	@Transient
	public static final int ACCOUNT_SUPPORT = 3;
	
	@Transient
	public static final int USER_SUPPORT = 4;

	@Transient
	public static final int REPORT_SUPPORT = 5;
	
	@Id
	@Column (name = "id_role")
	private int idRole;
	
	@NotEmpty
	@Column (name = "nameRole")
	private String nameRole;
	
	@OneToMany (mappedBy = "role")
	@JsonIgnore
	List<User> users;
	
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int idRole, String nameRole) {
		super();
		this.idRole = idRole;
		this.nameRole = nameRole;
	}

	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
}
