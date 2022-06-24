package com.example.SinnamonJDBC.controller;

import com.example.SinnamonJDBC.model.Author;
import com.example.SinnamonJDBC.model.Posts;
import com.example.SinnamonJDBC.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
    public List<Posts> getPostsForAuthor(@PathVariable String name){
        return authService.findPostsByName(name);
    }
    }

