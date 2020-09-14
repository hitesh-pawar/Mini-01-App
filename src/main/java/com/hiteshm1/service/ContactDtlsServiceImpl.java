package com.hiteshm1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		List<ContactDTO> contactList = new ArrayList<ContactDTO>();
		List<ContactDtlsEntity> entityList = repo.findAll();
		entityList.forEach(entity -> {
			ContactDTO contactDTO = new ContactDTO();
			BeanUtils.copyProperties(entity, contactDTO);
			contactList.add(contactDTO);
		});
		return contactList;
	}

	@Override
	public ContactDTO getContactById(Integer id) {
		Optional<ContactDtlsEntity> optional = repo.findById(id);
		if (optional.isPresent()) {
			ContactDtlsEntity entity = optional.get();
			ContactDTO contactDTO = new ContactDTO();
			BeanUtils.copyProperties(entity, contactDTO);
			return contactDTO;
		}
		return null;
	}

	@Override
	public boolean updateContact(ContactDTO dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		repo.deleteById(cid);
		return true;
	}

}
