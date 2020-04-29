package com.sisai.mynewapp.controller;
import java.time.LocalDate;      
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import javax.validation.Valid;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.sisai.mynewapp.exception.ResourceNotFoundException;
import com.sisai.mynewapp.listener.Person;
import com.sisai.mynewapp.manager.TimeService;
import com.sisai.mynewapp.model.Employee;
import com.sisai.mynewapp.repository.StvomRepository;
import com.sisai.mynewapp.service.SequenceGeneratorService;


@RestController
@RequestMapping("api/v2")
public class StvomController {
	
	@Autowired
	private StvomRepository stvomRepository;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	@Autowired
	private TimeService timeService;
	
	@GetMapping("/stvom")
	public List<Person> getAllData(){
		return stvomRepository.findAll();
	}
	
	@GetMapping("/stvom/random/{number}")
	public int[] getRandomData(@PathVariable(value="number") int number) {
		Random rd = new Random(); // creating Random object
	      int[] arr = new int[number];
	      for (int i = 0; i < arr.length; i++) {
	         arr[i] = rd.nextInt(100000); 
	      }
	      return arr;
	} 
	
	@GetMapping("/stvom/hours/{hours}")
	public List<Person> getData(@PathVariable(value="hours") long limit){
		return timeService.findByTimestamp(limit);
	}
	
	
	
	@GetMapping("/stvom/{id}")
	public ResponseEntity <Person> getDataById(@PathVariable(value = "id") Long dataId) throws ResourceNotFoundException{
		Person data=stvomRepository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + dataId));
		return ResponseEntity.ok().body(data);
	}
	
	@PostMapping("/stvom")
	public void createData(@Valid @RequestBody Person data) throws NullPointerException {
		data.setId(sequenceGeneratorService.generateSequence(Person.SEQUENCE_NAME));
		data.setTimestamp(data.getTimestamp());
		//System.out.println(localDate.now());
		stvomRepository.save(data);
	}
	
	@PutMapping("/stvom/{id}")
	public ResponseEntity <Person> updateData(@PathVariable(value = "id") Long dataId,
        @Valid @RequestBody Person dataDetails) throws ResourceNotFoundException{
		Person data=stvomRepository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + dataId));
		data.setTimestamp(dataDetails.getTimestamp());
		data.setGx(dataDetails.getGx());
		data.setGy(dataDetails.getGy());
		data.setGz(dataDetails.getGz());
		data.setThetaX(dataDetails.getThetaX());
		data.setThetaY(dataDetails.getThetaY());
		data.setTemp(dataDetails.getTemp());
		final Person updatedData=stvomRepository.save(data);
		return ResponseEntity.ok(updatedData);
	}
	
	@DeleteMapping("/stvom/{id}")
	public Map<String,Boolean> deleteData(@PathVariable (value="id") Long dataId) throws ResourceNotFoundException{
		Person data=stvomRepository.findById(dataId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + dataId));
		stvomRepository.delete(data);
		Map < String, Boolean > response = new HashMap <> ();
        response.put("deleted", Boolean.TRUE);
        return response;
	}
	
}