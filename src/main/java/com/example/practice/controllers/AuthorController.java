package com.example.practice.controllers;

import com.example.practice.entities.Author;
import com.example.practice.services.AuthorService;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService service;

    AuthorController(AuthorService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAuthors(ModelAndView model){
        model.addObject("authors", service.getAuthors());
        model.setViewName("authors");
        return model;
    }

    @RequestMapping(headers = "Accept=application/json", value="new", method = RequestMethod.POST)
    public ModelAndView addAuthor(@RequestParam String names, @RequestParam String surname, ModelAndView model){
        Author author = new Author();
        author.setNames(names);
        author.setSurname(surname);
        service.addAuthor(author);
        model.addObject("authors", service.getAuthors());
        model.setViewName("authors");
        return model;
    }

    @RequestMapping(value="/new",method = RequestMethod.GET)
    public ModelAndView newAuthor(ModelAndView model){
        model.setViewName("add_author_form");
        return model;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ModelAndView deleteAuthor(@RequestBody String body, ModelAndView model){
        JSONObject object = new JSONObject(body);
        Author author = new Author();
        author.setSurname(object.getString("surname"));
        author.setNames(object.getString("names"));
        author.setId(object.getInt("id"));
        service.deleteAuthor(author);
        model.addObject("authors", service.getAuthors());
        model.setViewName("authors");
        return model;
    }

    @RequestMapping("/update/{authorId}")
    public ModelAndView prepareUpdateAuthor(@PathVariable int authorId, ModelAndView model){
        Author author = service.getAuthorById(authorId);
        model.addObject("author", author);
        model.setViewName("update_author_form");
        return model;
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ModelAndView updateAuthor(@RequestBody String body, ModelAndView model){
        JSONObject jsonObject = new JSONObject(body);
        Author author = new Author();
        author.setId(jsonObject.getInt("authorId"));
        author.setNames(jsonObject.getString("names"));
        author.setSurname(jsonObject.getString("surname"));
        service.updateAuthor(author);

        model.addObject("authors", service.getAuthors());
        model.setViewName("authors");
        return model;
    }
}
