package com.cscoach.SpringDemo.dao.mappers;

import com.cscoach.SpringDemo.dto.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {

        Person p = new Person();
        p.setId(resultSet.getInt("id"));
        p.setName(resultSet.getString("name"));
        p.setLocation(resultSet.getString("location"));
        p.setBirth_date(resultSet.getDate("birth_date"));
        return p;
    }
}