package com.example.practice.config;

import com.example.practice.repositories.*;
import com.example.practice.services.AuthorService;
import com.example.practice.services.BookService;
import com.example.practice.services.RentedBookService;
import com.example.practice.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages={"com.example.practice.service", "com.example.practice.repositories"})
@Configuration
public class RootConfig{

    @Bean
    public BookService bookService(){
        return new BookService();
    }

    @Bean
    public BookDAO bookDAO(){
        return new BookDAOImpl();
    }

    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean
    public UserDAO userDAO(){ return new UserDAOImpl(); }

    @Bean
    public AuthorService authorService(){
        return new AuthorService();
    }

    @Bean
    public AuthorDAO authorDAO(){
        return new AuthorDAOImpl();
    }

    @Bean
    public RentedBookService rentedBookService(){
        return new RentedBookService();
    }

    @Bean
    public RentedBookDAO rentedBookDAOImpl(){
        return new RentedBookDAOImpl();
    }

    @Bean
    public DataSourceManager dataSourceManager(){
        return new DataSourceManager();
    }

}
