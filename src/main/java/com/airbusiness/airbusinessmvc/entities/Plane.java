package com.airbusiness.airbusinessmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    @NotBlank(message = "Type is mandatory")
    private String type;
    public String getType() {
    	return type;
    }
    public void setType(String type) {
    	this.type = type;
    }
    
    private int capacity;
    public int getCapcity() {
    	return capacity;
    }
    public void setCapacity(int capacity) {
    	this.capacity = capacity;
    }
    
    private int weightLimit;
    public int getWeightLimit() {
    	return weightLimit;
    }
    public void setWeightLimit(int weightLimit) {
    	this.weightLimit = weightLimit;
    }
}
