package com.airbusiness.airbusinessmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Pilot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String firstName;
	private String lastName;
	private String address;
	private String telephone;
	private String aircraftRating;
	private String arrivalAirport;
	private String departureAirport;
	private String licenseExpiration;
	private String licenseNumber;

}
