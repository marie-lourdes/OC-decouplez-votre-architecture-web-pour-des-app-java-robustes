package com.airbusiness.airbusinessmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name="reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Name of Reservation is mandatory")
	private String name;
    //@NotBlank(message = "Destination is mandatory")
    @Pattern(regexp="^(\\D*)", message= "String type")
	private String destination;
	private String departureDate;
	private String returnDate;
}
