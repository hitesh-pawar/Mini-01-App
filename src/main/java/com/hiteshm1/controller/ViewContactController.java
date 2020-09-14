package com.hiteshm1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hiteshm1.domain.ContactDTO;
import com.hiteshm1.service.ContactDtlsService;

@Controller
public class ViewContactController {

	@Autowired
	private ContactDtlsService service;

	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer id, Model model) {
		ContactDTO contactDTO = service.getContactById(id);
		model.addAttribute("contact", contactDTO);
		return "index";

	}

	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer contactId, RedirectAttributes attributes) {
		service.deleteContact(contactId);
		attributes.addFlashAttribute("delSucc", "Delete Contact Successfully");
		return "redirect:viewContacts";
	}
}
