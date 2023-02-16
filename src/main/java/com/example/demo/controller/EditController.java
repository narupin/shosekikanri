package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EditController {

	private final BookService service;
	
	@PostMapping("/edit")
	public String postEdit(@ModelAttribute @Validated Book book,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("book",book);
			return "edit";
		}
		
		this.service.update(book.getId(),
							book.getTitle(),
							book.getAuthor());
		return "redirect:/";
	}
}
