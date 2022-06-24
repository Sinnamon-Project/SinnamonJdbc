package com.example.SinnamonJDBC.repository;
import com.example.SinnamonJDBC.model.Posts;
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

    public List<Posts> findAllPosts(){
        String mySQL = "select * from blog_post";
        List <Posts> p= jdbcTemplate.query(mySQL, new PostRowMapper());
        return p;
    }
    public List <Posts> findAllPostsById(int id){
        String mySql = "select * from blog_post  where author = ?";
        List <Posts> b =  jdbcTemplate.query(mySql, new PostRowMapper(),id );
        return b;
    }
    public void saveNewPost(Posts post){
        String mySql = "insert into blog_post(title,text_post,picture,author) values (?,?,?,?)";
        int num = jdbcTemplate.update(mySql, post.getTitle(), post.getText_post(), post.getPicture(), post.getAuthor());
        System.out.println(num);
    }
    public void updatePostTitle(String title, int id){
        String mySql = "update blog_post set title = ? where post_id = ? ";
        jdbcTemplate.update(mySql,title,id);
    }
    public void updatePostText(String text, int id){
        String mySql = "update blog_post set text_post = ? where post_id = ? ";
        jdbcTemplate.update(mySql,text, id);
    }
    public void updatePostPic(String pic, int id){
        String mySql = "update blog_post set picture = ? where post_id = ? ";
        jdbcTemplate.update(mySql,pic, id);
    }
//    public void updateAll(String updatedTitle,String updatedText, String updatedPic,int id){
//        String mySql = "update blog_post set title = ? , text_post = ?, picture = ? where post_id = ? ";
//        jdbcTemplate.update(mySql,updatedTitle,updatedText,updatedPic,id);
//    }
    public void deletePost (int id){
        String mySql = "delete from blog_post where post_id = ? ";
        jdbcTemplate.update(mySql,id);
    }

    


    private  class PostRowMapper  implements RowMapper<Posts>{
        @Override
        public Posts mapRow(ResultSet rs, int rowNum) throws SQLException {
            Posts post=new Posts();
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

