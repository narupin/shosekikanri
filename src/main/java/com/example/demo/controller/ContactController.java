package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactController {

	private final ContactService service;
	
	@GetMapping("/")
	public String getContact(@ModelAttribute Contact contact,Model model) {
		return "contact";
	}
	
	@PostMapping("/")
	public String postContact(@ModelAttribute Contact contact,Model model) {
		return "contact";
	}
	
	@GetMapping("/complete")
	public String getComplete(Model model) {
		return "complete";
	}
	
	@PostMapping("/confirm")
	public String postContact(@ModelAttribute @Validated Contact contact,
								BindingResult result,
								Model model) {
		if(result.hasErrors()) {
			return "contact";
		}
		return "confirm";
	}
	
	@PostMapping("/complete")
	public String postConfirm(Contact contact) {
		this.service.save(contact.getName(),
							contact.getEmail(),
							contact.getMessage());
		return "redirect:/contact/complete";
	}
}
