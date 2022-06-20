package com.example.SinnamonJDBC.controller;

import com.example.SinnamonJDBC.model.Author;
import com.example.SinnamonJDBC.model.Blog_post;
import com.example.SinnamonJDBC.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authService;

    @GetMapping("/authors")
        public List<Author> getAllAuthors(){
            return authService.getAllAuthors();
        }

     @PostMapping("/authors")
        public void createNewAuthor(@RequestBody Author newAuthor){
            authService.createAuthor(newAuthor);
     }

    @GetMapping("/blog_posts/author/{name}")
    public List<Blog_post> getPostsForAuthor(@PathVariable String name){
        return authService.findPostsByName(name);
    }
    }

