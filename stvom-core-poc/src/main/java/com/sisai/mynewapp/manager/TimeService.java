package com.sisai.mynewapp.manager;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.sisai.mynewapp.listener.Person;
import com.sisai.mynewapp.repository.StvomRepository;
import org.bson.Document;



import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class TimeService{
	
	@Autowired
	private MongoTemplate mongoTemplate; 
	
	public List<Person> findByTimestamp(long hours){
		LocalDateTime end=LocalDateTime.now();
		LocalDateTime start=end.minusHours(hours);
		Criteria criteria=Criteria.where("localDate").gte(start).lte(end);
		Query q=new Query(criteria);
		return mongoTemplate.find(q, Person.class);
	}
}
