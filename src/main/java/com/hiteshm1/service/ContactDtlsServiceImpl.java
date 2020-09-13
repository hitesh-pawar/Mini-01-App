package com.hiteshm1.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiteshm1.domain.ContactDTO;
import com.hiteshm1.entity.ContactDtlsEntity;
import com.hiteshm1.entity.ContactDtlsRepository;

@Service
public class ContactDtlsServiceImpl implements ContactDtlsService {

	@Autowired
	private ContactDtlsRepository repo;

	@Override
	public boolean saveContact(ContactDTO dto) {
		ContactDtlsEntity entity = new ContactDtlsEntity();
		BeanUtils.copyProperties(dto, entity);
		ContactDtlsEntity savedEntity = repo.save(entity);
		return savedEntity.getContactId() != null;
	}

	@Override
	public List<ContactDTO> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactDTO getContactById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateContact(ContactDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		// TODO Auto-generated method stub
		return false;
	}

}
