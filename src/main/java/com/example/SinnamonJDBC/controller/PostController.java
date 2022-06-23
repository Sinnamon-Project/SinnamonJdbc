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

    @GetMapping("/posts/{id}")
    List<Blog_post> findPostsbyId(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @GetMapping("/posts")
    public List<Blog_post> getAllDepartments(){
        return postService.getAllDepartments();
    }

    @PostMapping("/posts")
    public ResponseEntity<?> createPost(@RequestBody Blog_post blogPost) {
        postService.createPost(blogPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(blogPost);
    }
    @PostMapping("/posts/updateTitle/{id}")
    public void updateTitle(@PathVariable int id,@RequestBody Blog_post updatedTitle) {
        System.out.println(updatedTitle.getTitle());
        postService.updateTitle(updatedTitle.getTitle(),id);
    }

    @PostMapping("/posts/updateText/{id}")
    public void updateText(@PathVariable int id,@RequestBody Blog_post updatedText){
        System.out.println(updatedText.getText_post());
        postService.updateText(updatedText.getText_post(),id);
    }

    @PostMapping("/posts/updatePic/{id}")
    public void updatePic(@PathVariable int id,@RequestBody Blog_post updatedPic){
        postService.updatePic(updatedPic.getPicture(),id);
    }
//    @PostMapping("/posts/edit/{id}")
//    public void updateAll(@RequestBody Blog_post updatedTitle,@RequestBody Blog_post updatedText,@RequestBody Blog_post updatedPic,@PathVariable int id) {
//        postService.updateAll(updatedTitle.getTitle(),updatedText.getText_post(),updatedPic.getPicture(),id);
//    }

    @PostMapping("/posts/delete/{id}")
    public void deletePost(@PathVariable int id){
        postService.deletePost(id);
    }
}
