package com.sisai.mynewapp.listener;

import org.bson.types.ObjectId;     
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection="sampledata1")
public class Person{
	private double Gx;
	private double Gy;
	private double Gz;
	private double ThetaX;
	private double ThetaY;
	private double Temp;
	//private Date timestamp=new Date();
	//ZoneId zone=ZoneId.of("Asia/Kolkata");
	private LocalDateTime localDate=LocalDateTime.now();
	
	@Id
    private long id;
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	public Person() {
		super();
	}
	
	public Person(double Gx, double Gy, double Gz, double ThetaX, double ThetaY , double Temp, LocalDateTime localDate) {
	    super();
	    this.localDate=localDate;
	    this.Gx = Gx;
	    this.Gy = Gy;
	    this.Gz = Gz;
	    this.ThetaX = ThetaX;
	    this.ThetaY = ThetaY;
	    this.Temp = Temp;
	    
	  }
	
	public long getId() {
        return id;
    }
    public void setId(long l) {
    	this.id = l;
    }
    
    
    
    public LocalDateTime getTimestamp() {
    	
    	return localDate;
    	//return timestamp.toInstant().atZone(ZoneId.systemDefault()).totimestamp();
    }
    
    public void setTimestamp(LocalDateTime localDate) {
    	
    	this.localDate=localDate;
    }
	
	public double getGx() {
		return Gx;
	}
	public void setGx(double param) {
		this.Gx=param;
	}
	public double getGy() {
		return Gy;
	}
	public void setGy(double param) {
		this.Gy=param;
	}
	public double getGz() {
		return Gz;
	}
	public void setGz(double param) {
		this.Gz=param;
	}
	public double getThetaX() {
		return ThetaX;
	}
	public void setThetaX(double param) {
		this.ThetaX=param;
	}
	public double getThetaY() {
		return ThetaY;
	}
	public void setThetaY(double param) {
		this.ThetaY=param;
	}
	public double getTemp() {
		return Temp;
	}
	public void setTemp(double param) {
		this.Temp=param;
	}
	
	@Override
	  public String toString() {
	    return "{Gx:" + Gx + ", Gy:" + Gy + ", Gz:" + Gz + ", ThetaX:" + ThetaX + ", ThetaY:" + ThetaY + ", Temp:" + Temp + ", Date:" + localDate + "}";
	  }

	
}
