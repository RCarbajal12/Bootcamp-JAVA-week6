package com.romina.bookapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.romina.bookapi.models.BookModel;
import com.romina.bookapi.services.BookService;

@RestController
public class BookApiController {
	
//	@RestController
//	public class BooksApi {
//	    private final BookService bookService;
//	    public BooksApi(BookService bookService){
//	        this.bookService = bookService;
//	    }
	    
	    @Autowired
	    private  BookService bookService;
	    
	    
	    //MOSTRAR INFORMACIÒN DE TODOS LOS LIBROS
	    @GetMapping("/api/books")
	    public List<BookModel> index() {
	        return bookService.allBooks();
	    }
	    
	   //CREAR UN LIBRO
	    @PostMapping(value="/api/books")
	    public BookModel create(@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String desc,
	    		@RequestParam(value="language") String lang, 
	    		@RequestParam(value="pages") Integer numOfPages) {
	        BookModel book = new BookModel(title, desc, lang, numOfPages);
	        return bookService.createBook(book);
	    }
	    
	    //MOSTRAR INFORMACION DE UN LIBRO ESPECIFICO
	    @GetMapping("/api/books/{id}")
	    public BookModel show(@PathVariable("id") Long id) {
	        BookModel book = bookService.findBook(id);
	        return book;
	    }
	
	    //ACTUALIZAR INFORMACION DE UN LIBRO ESPECIFICO
	    @PutMapping("/api/books/{id}")
	    public BookModel actualizar(@PathVariable("id")Long id,
	    		@RequestParam(value="title") String title, 
	    		@RequestParam(value="description") String desc,
	    		@RequestParam(value="language") String lang, 
	    		@RequestParam(value="pages") Integer numOfPages) {
	    	BookModel book = new BookModel(id, title, desc, lang,numOfPages);
	        return bookService.actualizarLibro(book);
	    	//return bookService.actualizarLibro(id, title, desc, lang,numOfPages );
	    }
	    
	    //BORRAR REGISTRO
	    @DeleteMapping("/api/books/{id}")
	    public void borrarRegistro(@PathVariable("id")Long id) {
	    	bookService.borrarRegistro(id);
	    }

}
