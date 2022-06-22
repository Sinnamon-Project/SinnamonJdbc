package com.example.SinnamonJDBC.service;

import com.example.SinnamonJDBC.model.Author;
import com.example.SinnamonJDBC.model.Blog_post;
import com.example.SinnamonJDBC.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public void createPost(Blog_post new_Post) {
        postRepository.saveNewPost(new_Post);
    }

    public List<Blog_post> getPostById(int id) {
        return postRepository.findAllPostsById(id);
    }

    public List<Blog_post> getAllBlogs() {
        return postRepository.findAllBlogs();
    }

    public void updateTitle(String title, int id){
        postRepository.updatePostTitle(title,id);
    }
    public void updateText(Blog_post updateText){
        postRepository.updatePostText(updateText);
    }

    public void updatePic(Blog_post updatePic){
        postRepository.updatePostPic(updatePic);
    }
}

