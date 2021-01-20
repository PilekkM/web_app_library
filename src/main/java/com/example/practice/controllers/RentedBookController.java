package com.example.practice.controllers;

import com.example.practice.entities.RentedBook;
import com.example.practice.services.AuthorService;
import com.example.practice.services.BookService;
import com.example.practice.services.RentedBookService;
import com.example.practice.services.UserService;
import org.dom4j.rule.Mode;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;

@Controller
@RequestMapping("/books/rental")
public class RentedBookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    private RentedBookService service;

    RentedBookController(RentedBookService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getRentedBooks(ModelAndView model){
        model.addObject("rented_books", service.getRentedBooks());
        model.setViewName("rented_books");
        return model;
    }

    @RequestMapping(value = "/new")
    public ModelAndView prepareAddBookRental(ModelAndView model){
        model.addObject("users", userService.getUsers());
        model.addObject("books", bookService.getBooks());
        model.setViewName("add_book_rental_form");
        return model;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView addBookRental(@RequestParam(value = "user_id") int userId, @RequestParam(value = "book_id") int bookId, ModelAndView model){
        RentedBook rentedBook = new RentedBook();
        rentedBook.setBook(bookService.getBookById(bookId));
        rentedBook.setUser(userService.getUserById(userId));
        rentedBook.setReturnDate(new Date(System.currentTimeMillis() + 604800000));
        service.addRentedBook(rentedBook);

        model.addObject("rented_books", service.getRentedBooks());
        model.setViewName("rented_books");

        return model;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ModelAndView deleteBookRental(@RequestBody String body, ModelAndView model){
        JSONObject jsonObject = new JSONObject(body);
        RentedBook rentedBook = new RentedBook();
        rentedBook.setBook(bookService.getBookById(jsonObject.getInt("book_id")));
        rentedBook.setUser(userService.getUserById(jsonObject.getInt("user_id")));
        rentedBook.setId(jsonObject.getInt("id"));
        service.deleteRentedBook(rentedBook);

        model.addObject("rented_books", service.getRentedBooks());
        model.setViewName("rented_books");

        return model;
    }
}
