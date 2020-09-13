package com.hiteshm1.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "contact_dtls")
public class ContactDtlsEntity {

	@Id
	@GeneratedValue
	@Column(name = "contact_id")
	private Integer contactId;

	@Column(length = 50, name = "contact_name")
	private String contactName;

	@Column(length = 50, name = "contact_email")
	private String contactEmail;

	@Column(length = 10, name = "contact_num")
	private long contactNum;

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public long getContactNum() {
		return contactNum;
	}

	public void setContactNum(long contactNum) {
		this.contactNum = contactNum;
	}
	
	

}
