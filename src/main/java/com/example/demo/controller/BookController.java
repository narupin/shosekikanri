package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

	private final BookService service;
	
	@GetMapping("/")
	public String getIndex(@ModelAttribute Book book, Model model) {
		model.addAttribute("books",this.service.findAll());
		return "index";
	}
	
	@PostMapping("/")
	public String postIndex(@ModelAttribute @Validated Book book,BindingResult result,Model model) {
		
		
		// 入力チェックに引っかかったら登録しないで戻る
		if(result.hasErrors()) {
			model.addAttribute("books",this.service.findAll());
			return "index";
		}
		
		// 入力チェックに問題なければ登録する
		this.service.save(book.getTitle(), book.getAuthor());
		// 登録後、書籍一覧を取り出す
		model.addAttribute("books",this.service.findAll());
		
		return "redirect:/";
	}
	
	@PutMapping("/{id}")
	public String putIndex(@PathVariable Long id,Model model) {
		
		Optional<Book> bookOpt = this.service.findById(id);
		Book book = bookOpt.get();
		model.addAttribute("book",book);
		
		return "edit";
	}
	
	@DeleteMapping("/{id}")
	public String deleteIndex(@PathVariable Long id) {
		this.service.delete(id);
		return "redirect:/";
	}
}