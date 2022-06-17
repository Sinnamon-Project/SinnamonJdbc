package com.example.SinnamonJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Author> findAllAuthors() {
        return jdbcTemplate.query("select * from author", new AuthorRowMapper());
    }

    public Author findOneAuthor(String name){
       String mySql = "select * from author  where last_name = ?";
        Author n =  jdbcTemplate.queryForObject(mySql, new AuthorRowMapper(), name );
        //int result = jdbcTemplate.queryForObject( “select count(*) 	from Author”, Integer.class);
        return n;
    }
    private class AuthorRowMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            Author author = new Author();
            author.setAuthor_id(rs.getInt("author_id"));
            author.setFirst_name(rs.getString("first_name"));
            author.setLast_name(rs.getString("last_name"));
            return author;
        }

    }
}