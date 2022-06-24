package com.example.SinnamonJDBC.controller;

import com.example.SinnamonJDBC.model.Posts;
import com.example.SinnamonJDBC.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/posts/{id}")
    List<Posts> findPostbyId(@PathVariable int id) {
        return postService.getPostById(id);
    }

    @GetMapping("/posts")
    public List<Posts> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping("/posts")
    public ResponseEntity<?> createPost(@RequestBody Posts post) {
        postService.createPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }
    @PostMapping("/posts/updateTitle/{id}")
    public void updateTitle(@PathVariable int id,@RequestBody Posts updatedTitle) {
        System.out.println(updatedTitle.getTitle());
        postService.updateTitle(updatedTitle.getTitle(),id);
    }

    @PostMapping("/posts/updateText/{id}")
    public void updateText(@PathVariable int id,@RequestBody Posts text){
        System.out.println(text.getText_post());
        postService.updateText(text.getText_post(),id);
    }

    @PostMapping("/posts/updatePic/{id}")
    public void updatePic(@PathVariable int id,@RequestBody Posts pic){
        postService.updatePic(pic.getPicture(),id);
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
