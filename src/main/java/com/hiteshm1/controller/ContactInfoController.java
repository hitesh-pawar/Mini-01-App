package com.hiteshm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hiteshm1.domain.ContactDTO;
import com.hiteshm1.service.ContactDtlsService;

@Controller
public class ContactInfoController {

	@Autowired
	private ContactDtlsService service;
	
	@GetMapping("/") 
	public String loadContactForm(Model model) {
		ContactDTO contactDTO = new ContactDTO();
		model.addAttribute("contact", contactDTO);
		return "index";
	}

	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") ContactDTO contactDTO, Model model) {
		boolean isSaved =  service.saveContact(contactDTO);
		if (isSaved) {
			model.addAttribute("succMsg", "Contact Saved");
		}else {
			model.addAttribute("errMsg", "Failed to Save Contact");
		}
		return "index";
	}

	public String handleViewCtcsHyperlink(Model model) {
		return null;
	}
}
