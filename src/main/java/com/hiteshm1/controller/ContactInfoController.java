package com.hiteshm1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String handleSubmitBtn(@ModelAttribute("contact") ContactDTO contactDTO, RedirectAttributes attributes) {
		boolean isSaved = service.saveContact(contactDTO);
		if (isSaved) {
			if (contactDTO.getContactId() != null) {
				attributes.addFlashAttribute("succMsg", "Contact Updated Successfully");
			} else {
				attributes.addFlashAttribute("succMsg", "Contact Saved Successfully");
			}
		} else {
			attributes.addFlashAttribute("errMsg", "Failed to Save Contact");
		}
		return "redirect:/contactCreationSuccess";
	}

	@RequestMapping(value = "/contactCreationSuccess", method = RequestMethod.GET)
	public String contactCreationSuccess(Model model) {
		model.addAttribute("contact", new ContactDTO());
		return "index";
	}

	@RequestMapping("/viewContacts")
	public String handleViewCtcsHyperlink(Model model) {
		List<ContactDTO> allContacts = service.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return "viewContacts";
	}
}
