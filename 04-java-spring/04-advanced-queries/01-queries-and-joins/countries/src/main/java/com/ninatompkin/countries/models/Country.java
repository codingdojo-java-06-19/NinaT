package com.ninatompkin.countries.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="countries")
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Size(max=3)
	private String code;
	@Size(max=52)
	private String name;
	private String continent;
	@Size(max=26)
	private String region;
	private Double surface_area;
	@Size(max=6)
	private Short indep_year;
	private int population;
	private Double life_expectancy;
	private Double gnp;
	private Double gnp_old;
	@Size(max=45)
	private String local_name;
	@Size(max=45)
	private String government_form;
	@Size(max=60)
	private String head_of_state;
	private int capital;
	@Size(max=2)
	private String code2;
	
	//Not sure if need....
//	@Column(updatable=false)
//	private Date createdAt;
//	private Date updatedAt;

	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private List<Language> languages;
	
	@OneToMany(mappedBy="country", fetch=FetchType.LAZY)
	private List<City> cities;
	
	public Country() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Double getSurface_area() {
		return surface_area;
	}

	public void setSurface_area(Double surface_area) {
		this.surface_area = surface_area;
	}

	public Short getIndep_year() {
		return indep_year;
	}

	public void setIndep_year(Short indep_year) {
		this.indep_year = indep_year;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public Double getLife_expectancy() {
		return life_expectancy;
	}

	public void setLife_expectancy(Double life_expectancy) {
		this.life_expectancy = life_expectancy;
	}

	public Double getGnp() {
		return gnp;
	}

	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}

	public Double getGnp_old() {
		return gnp_old;
	}

	public void setGnp_old(Double gnp_old) {
		this.gnp_old = gnp_old;
	}

	public String getLocal_name() {
		return local_name;
	}

	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}

	public String getGovernment_form() {
		return government_form;
	}

	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}

	public String getHead_of_state() {
		return head_of_state;
	}

	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}

	public int getCapital() {
		return capital;
	}

	public void setCapital(int capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
	
}
