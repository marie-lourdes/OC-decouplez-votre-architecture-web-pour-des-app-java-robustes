package com.airbusiness.airbusinessmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
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
}
