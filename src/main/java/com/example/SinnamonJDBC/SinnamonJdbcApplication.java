package com.example.SinnamonJDBC;

import com.example.SinnamonJDBC.repository.AuthorRepository;
import com.example.SinnamonJDBC.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SinnamonJdbcApplication {

	@Autowired
    AuthorRepository authorRep;
	@Autowired

	PostRepository postRep;

	public static void main(String[] args) {
		SpringApplication.run(SinnamonJdbcApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//		List<Author> autList = authorRep.findAllAuthors();
//		for (Author a : autList) {
//			System.out.println(a);
//		}
//
//		Author auth = authorRep.findOneAuthor("Hendy");
//		System.out.println("this is from author rep " + auth);
//
//		List<Blog_post> posts = postRep.findAllBlogs();
//		for (Blog_post b : posts) {
//			System.out.println(b);
//		}
//
//
//	}
}
















