package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	// タイトルで検索
	List<Book> findByTitleContaining(String title);
	// 著者で検索
	List<Book> findByAuthorContaining(String author);
	
}
