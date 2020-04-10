package com.cscoach.SpringDemo.dao;

import com.cscoach.SpringDemo.dao.mappers.PersonMapper;
import com.cscoach.SpringDemo.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonDAO {

    @Autowired
    JdbcTemplate jdbcTemp;

    public List<Person> findAllPersons(){
      return jdbcTemp.query("select * from persons",new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id){
        return jdbcTemp.queryForObject("select * from persons where id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
    }

    public int deleteById(int id){
        return jdbcTemp.update("delete from persons where id = ?", new Object[]{id});
    }

    public int insertData(Person person){
        return jdbcTemp.update("insert into persons values (?,?,?,?)",new Object[]{person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirth_date().getTime())});
    }

    public int updateData(Person person){
        return jdbcTemp.update("update persons set name = ?,location = ?, birth_date = ? where id = ?",new Object[]{person.getName(),person.getLocation(),new Timestamp(person.getBirth_date().getTime()),person.getId()});
    }

    public Person findByIdUsingCustomRowMapper(int id){
        return jdbcTemp.queryForObject("select * from persons where id = ?", new Object[]{id}, new PersonMapper());
    }

}
