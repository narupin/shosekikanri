package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

	private final BookRepository repository;
	
	// 入力したタイトル、著者をデータベースに登録する
	public void save(String title,String author) {
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		this.repository.save(book);
	}
	
	// 編集した書籍データで上書きする
	public void update(Long id,String title,String auhtor) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setAuthor(auhtor);
		this.repository.save(book);
	}
	
	// 全ての書籍データを返す
	public List<Book> findAll(){
		return this.repository.findAll();
	}
	
	// 指定のIDの書籍データを返す
	public Optional<Book> findById(Long id) {
		return this.repository.findById(id);
	}
	
	// 指定の書籍データを編集し保存する
	public void edit(Book book) {
		this.repository.saveAndFlush(book);
	}
	
	// 指定の書籍データを削除する
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
	
	// 全ての書籍データを削除する
	public void deleteAll() {
		this.repository.deleteAll();
	}
}
