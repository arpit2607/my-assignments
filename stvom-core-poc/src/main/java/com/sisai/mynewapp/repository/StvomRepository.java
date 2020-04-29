package com.sisai.mynewapp.repository;

import java.time.LocalDateTime; 
import java.util.List;

import org.bson.Document;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.sisai.mynewapp.listener.Person;


@Repository
public interface StvomRepository extends MongoRepository<Person, Long>{
	
}
