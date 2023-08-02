package com.romina.bookapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.romina.bookapi.models.BookModel;
import com.romina.bookapi.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {

	    /*private final BookService bookService;
	    
	    public BookController(BookService bookService) {
	        this.bookService = bookService;
	    }
	    */
	
	    @Autowired
	    private BookService bookService;
	    
	    //TODOS LOS LIBROS
	    @GetMapping("/books")
	    public String index(Model model) {
	        List<BookModel> books = bookService.allBooks();
	        model.addAttribute("books", books);
	        return "books/index.jsp";
	    }
	    
	    @GetMapping("/books/new")
	    public String formularioLibro(@ModelAttribute("libro")BookModel book) {
	    	
	    	return "books/new.jsp";
	    }
	    
	    
//	    @RequestMapping("/books/new")
//	    public String newBook(@ModelAttribute("book") Book book) {
//	        return "/books/new.jsp";
//	    }

	    @GetMapping("/books/{id}")
	    public String show(@PathVariable Long id, Model model) {
	        BookModel book = bookService.findBook(id);

	        if (book != null) {
	            model.addAttribute("book", book);
	            return "books/show.jsp";
	        } else {
	            return "redirect:/books";
	        }
	    }

	    @PostMapping("/books")
	    public String create(@Valid @ModelAttribute("libro") BookModel book, BindingResult result, Model viewMode) {
	        if (result.hasErrors()) {
	            return "books/new.jsp";
	        } else {
	            bookService.createBook(book);
	            return "redirect:/books";
	        }
	    }

}
