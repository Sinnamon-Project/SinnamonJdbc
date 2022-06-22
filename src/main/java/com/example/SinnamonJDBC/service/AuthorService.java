package com.example.SinnamonJDBC.service;

import com.example.SinnamonJDBC.model.Author;
import com.example.SinnamonJDBC.model.Blog_post;
import com.example.SinnamonJDBC.repository.AuthorRepository;
import com.example.SinnamonJDBC.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authRepository;
    @Autowired
    PostRepository postRepository;

    public List<Author> getAllAuthors() {
        return authRepository.findAllAuthors();
    }

    public void createAuthor(Author auth) {
        authRepository.saveNewAuthor(auth);
    }

    public List<Blog_post> findPostsByName(String lastName) {
        Author a = authRepository.findOneAuthor(lastName);
        List <Blog_post> bp = postRepository.findAllPostsById(a.getAuthor_id());
        return bp;
    }


}