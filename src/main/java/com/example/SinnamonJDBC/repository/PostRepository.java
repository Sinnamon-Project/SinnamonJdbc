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
    public List <Blog_post> findAllPostsById(int id){
        String mySql = "select * from blog_post  where author = ?";
        List <Blog_post> b =  jdbcTemplate.query(mySql, new PostRowMapper(),id );
        return b;
    }
    public void saveNewPost(Blog_post newPost){
        String mySql = "insert into blog_post(title,text_post,picture,author) values (?,?,?,?)";
        int num = jdbcTemplate.update(mySql, newPost.getTitle(), newPost.getText_post(), newPost.getPicture(), newPost.getAuthor());
        System.out.println(num);
    }
    public void updatePostTitle(String updatedTitle, int id){
        String mySql = "update blog_post set title = ? where post_id = ? ";
        jdbcTemplate.update(mySql,updatedTitle,id);
    }
    public void updatePostText(String updatedText, int id){
        String mySql = "update blog_post set text_post = ? where post_id = ? ";
        jdbcTemplate.update(mySql,updatedText, id);
    }
    public void updatePostPic(String updatedPic, int id){
        String mySql = "update blog_post set picture = ? where post_id = ? ";
        jdbcTemplate.update(mySql,updatedPic, id);
    }
//    public void updateAll(String updatedTitle,String updatedText, String updatedPic,int id){
//        String mySql = "update blog_post set title = ? , text_post = ?, picture = ? where post_id = ? ";
//        jdbcTemplate.update(mySql,updatedTitle,updatedText,updatedPic,id);
//    }
    public void deletePost (int id){
        String mySql = "delete from blog_post where post_id = ? ";
        jdbcTemplate.update(mySql,id);
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

