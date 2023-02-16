package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookSearchService {

	private final BookRepository repository;
	
	// タイトルで検索し含まれるもののリストを返す
	public List<Book> findByTitleContaining(String title) {
		return this.repository.findByTitleContaining(title);
	}
	
	// 著者で検索し含まれるもののリストを返す
	public List<Book> findByAuthorContaining(String author) {
		return this.repository.findByAuthorContaining(author);
	}
	
	// 全ての書籍データを返す
	public List<Book> findAll(){
		return this.repository.findAll();
	}
	
}
