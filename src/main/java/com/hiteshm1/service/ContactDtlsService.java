package com.hiteshm1.service;

import java.util.List;

import com.hiteshm1.domain.ContactDTO;

public interface ContactDtlsService {

	public boolean saveContact(ContactDTO dto);

	public List<ContactDTO> getAllContacts();

	public ContactDTO getContactById(Integer id);

	public boolean updateContact(ContactDTO dto);

	public boolean deleteContact(Integer cid);

}
