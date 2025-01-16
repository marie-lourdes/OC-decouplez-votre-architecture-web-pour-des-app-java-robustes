package com.airbusiness.airbusinessmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name of Reservation is mandatory")
    private String name;
    @NotBlank(message = "Destination is mandatory")
    private String destination;
    private String departureDate;
    private String returnDate;

    public Reservation() {}

    public Reservation(String name, String destination, String departureDate, String returnDate) {
        this.name = name;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }

    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getDestination() {
    	return destination;
    }
    
    public void setDestination (String destination) {
    	this.destination = destination;
    }
    
    public String getDepartureDate () {
    	return departureDate;
    }
    
    public void setDepartureDate (String departureDate) {
    	this.departureDate = departureDate;
    }
    
    public String getReturnDate () {
    	return returnDate;
    }
    
    public void setReturnDate (String returnDate) {
    	this.returnDate = returnDate;
    }
}
