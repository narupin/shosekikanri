package com.example.demo.controller;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Book;
import com.example.demo.service.BookSearchService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/search")
public class BookSearchController {

	private final BookSearchService service;
	
	// タイトルで検索
	@GetMapping("/title")
	public String getSearchTitle(@RequestParam(required = false) String title,
							Model model) {
		if(!Objects.isNull(title) && !title.isBlank()) {
			model.addAttribute("books",this.service.findByTitleContaining(title));
			model.addAttribute("book",new Book());
		}else {
			return "redirect:/";
		}
		return "index";
	}
	
	// 著者で検索
	@GetMapping("/author")
	public String getSearchAuthor(@RequestParam(required = false) String author,
							Model model) {
		if(!Objects.isNull(author) && !author.isBlank()) {
			model.addAttribute("books",this.service.findByAuthorContaining(author));
			model.addAttribute("book",new Book());
		}else {
			return "redirect:/";
		}
		return "index";
	}	
}
