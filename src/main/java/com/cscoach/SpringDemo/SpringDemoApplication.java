package com.cscoach.SpringDemo;

import com.cscoach.SpringDemo.dao.PersonDAO;
import com.cscoach.SpringDemo.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonDAO pdao;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
      logger.info("Time {} :: ALL PERSONS => {} ", Calendar.getInstance().getTime(), pdao.findAllPersons());
      logger.info("Details for id = 100 => {}",pdao.findById(100));
      logger.info("Deleting id = 100 : rows affected = {} :: total size = {}",pdao.deleteById(100),pdao.findAllPersons().size());
      Person p = new Person();
      p.setId(200);
      p.setName("jack");
      p.setLocation("rotterdam");
      p.setBirth_date(new Date());
      logger.info("inserting data :: rows affected : {}",pdao.insertData(p));
      p.setId(200);
      p.setName("mark");
      p.setLocation("london");
      p.setBirth_date(new Date());
      logger.info("updating rows :: rows updated = {}",pdao.updateData(p));
      logger.info("custom mapper row details with id = 200 :: {}",pdao.findByIdUsingCustomRowMapper(200));
	}
}
