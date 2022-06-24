package com.example.SinnamonJDBC.service;

import com.example.SinnamonJDBC.model.Posts;
import com.example.SinnamonJDBC.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public void createPost(Posts post) {
        postRepository.saveNewPost(post);
    }
    public List<Posts> getPostById(int id) {
        return postRepository.findAllPostsById(id);
    }

    public List<Posts> getAllPosts(){ return postRepository.findAllPosts();
    }
    public void updateTitle(String title, int id){
        postRepository.updatePostTitle(title,id);
    }
    public void updateText(String text, int id){ postRepository.updatePostText(text, id);}
    public void updatePic(String pic, int id){postRepository.updatePostPic(pic,id);}
//    public void updateAll(String updateTitle, String updateText,String updatePic, int id){postRepository.updateAll(updateTitle,updateText,updatePic,id);}
    public void deletePost(int id){postRepository.deletePost(id);}
}

