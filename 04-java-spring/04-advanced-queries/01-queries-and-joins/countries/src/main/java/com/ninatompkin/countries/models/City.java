package com.ninatompkin.countries.models;

@Entity
@Table(name="cities")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
}
