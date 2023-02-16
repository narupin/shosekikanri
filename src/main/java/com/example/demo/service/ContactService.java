package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactService {

	private final ContactRepository repository;
	
	public void save(String name,String email,String message) {
		Contact contact = new Contact();
		contact.setName(name);
		contact.setEmail(email);
		contact.setMessage(message);
		this.repository.save(contact);
	}
}
