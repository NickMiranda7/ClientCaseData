package com.nick.ClientCaseData.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="members")
public class Member {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "If member has no current medicaid write N/A")
	private String meds_0;
	@NotNull
	private boolean revAG_0;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="client_id")
	private Client client;
	
	public Member() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMeds() {
		return meds_0;
	}

	public void setMeds(String meds) {
		this.meds_0 = meds;
	}

	public boolean isRevAG() {
		return revAG_0;
	}

	public void setRevAG(boolean revAG) {
		this.revAG_0 = revAG;
	}
	
}
