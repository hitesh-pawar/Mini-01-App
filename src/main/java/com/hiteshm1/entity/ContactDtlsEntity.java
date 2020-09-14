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

}
