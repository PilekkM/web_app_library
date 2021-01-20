package com.example.practice.controllers;

import com.example.practice.entities.Book;
import com.example.practice.services.AuthorService;
import com.example.practice.services.BookService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService service;
    @Autowired
    private AuthorService authorService;


    BookController(BookService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAllBooks(ModelAndView model){
        model.addObject("books", service.getBooks());
        model.setViewName("books");
        return model;
    }

    @RequestMapping(value = "/new")
    public ModelAndView newBook(ModelAndView model){
        model.addObject("authors", authorService.getAuthors());
        model.setViewName("add_book_form");
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView addBook(@RequestParam String title, @RequestParam(value = "author_id") int authorId, @RequestParam int quantity, @RequestParam(value = "in_rental") int inRental, ModelAndView model){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(authorService.getAuthorById(authorId));
        book.setQuantity(quantity);
        book.setInRental(inRental);
        service.addBook(book);
        model.addObject("books", service.getBooks());
        model.setViewName("books");
        return model;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ModelAndView deleteBook(@RequestBody String body, ModelAndView model){
        JSONObject jsonObject = new JSONObject(body);
        Book book = new Book();
        book.setId(jsonObject.getInt("id"));
        service.deleteBook(book);
        model.addObject("books", service.getBooks());
        model.setViewName("books");
        return model;
    }

    @RequestMapping(value = "/update/{book_id}", method=RequestMethod.GET)
    public ModelAndView redirectUpdateBook(@PathVariable int book_id, ModelAndView model){
        Book book = service.getBookById(book_id);
        model.addObject("book", book);
        model.addObject("authors", authorService.getAuthors());
        model.setViewName("update_book_form");
        return model;
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ModelAndView updateBook(@RequestBody String data, ModelAndView model){
        JSONObject jsonObject = new JSONObject(data);
        Book book = new Book();
        book.setId(jsonObject.getInt("bookId"));
        book.setAuthor(authorService.getAuthorById(jsonObject.getInt("authorId")));
        book.setTitle(jsonObject.getString("title"));
        book.setQuantity(jsonObject.getInt("quantity"));
        service.updateBook(book);

        model.addObject("books", service.getBooks());
        model.setViewName("books");
        return model;
    }

}
