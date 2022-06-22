package com.example.SinnamonJDBC.controller;

import com.example.SinnamonJDBC.model.Blog_post;
import com.example.SinnamonJDBC.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    //CREATING NEW POST:
    @PostMapping("/posts")
    public ResponseEntity<?> createPost(@RequestBody Blog_post blogPost) {
        postService.createPost(blogPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(blogPost);
    }

    //    Find all Posts by AuthorId:
    @GetMapping("/posts/{id}")
    List<Blog_post> findPostsbyId(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @PostMapping("/posts/updatetitle")
    public void updateTitle(@RequestBody Blog_post updatedTitle) {
        postService.updateText(updatedTitle);
    }

    @PostMapping("/posts/updatetext")
    public ResponseEntity<?> updateText(@RequestBody Blog_post updatedText){
        postService.updateText(updatedText);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedText);
    }

    @PostMapping("/posts/updatepic")
    public ResponseEntity<?> updatePic(@RequestBody Blog_post updatedPic){
        postService.updateText(updatedPic);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedPic);
    }






}
