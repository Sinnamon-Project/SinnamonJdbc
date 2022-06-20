package com.example.SinnamonJDBC.repository;
import com.example.SinnamonJDBC.model.Author;
import com.example.SinnamonJDBC.model.Blog_post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class PostRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Blog_post> findAllBlogs(){
        String mySQL = "select * from blog_post";
        List<Blog_post> posts = jdbcTemplate.query(mySQL, new PostRowMapper());
        return posts;
    }

    public List <Blog_post> findAllPosts(int id){
        String mySql = "select * from blog_post  where author = ?";
        List <Blog_post> b =  jdbcTemplate.query(mySql, new PostRowMapper(),id );
        return b;
    }


    private  class PostRowMapper  implements RowMapper<Blog_post>{
        @Override
        public Blog_post mapRow(ResultSet rs, int rowNum) throws SQLException {
            Blog_post post=new Blog_post();
            post.setPost_id(rs.getInt("post_id"));post.setPost_id(rs.getInt("post_id"));
            post.setTitle(rs.getString("title"));
            post.setDate_time(rs.getString("date_time"));
            post.setText_post(rs.getString("text_post"));
            post.setPicture(rs.getString("picture"));
            post.setAuthor(rs.getInt("author"));

            return post;



        }
    }

}
