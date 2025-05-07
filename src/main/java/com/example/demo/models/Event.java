package com.example.demo.models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Event{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int event_id;
	@NotNull
	private String title;
	@NotNull
	private String about;
	@NotNull
	private Date date;
	@NotNull
	private String location;
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName = "user_id")
	private User user;
	
	

}
