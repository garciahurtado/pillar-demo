package com.garciahurtado.pillardemo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="newspapers")
public class NewspaperModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	private ArrayList<AdModel> ads;
	
	public NewspaperModel(){
		
	}

	public NewspaperModel(String name) {
		// TODO: externalize name regexp into custom validator 
		// Only Alphanumeric, space and dash are allowed
		if(!name.matches("^[a-zA-Z0-9-\\s]*$")){
			throw new IllegalArgumentException("The newspaper name can only contain alphanumeric characters, spaces or dashes");
		}
		this.name = name;
		this.ads = new ArrayList<AdModel>();
	}

	public List<AdModel> getAds() {
		return ads;
	}
	
	public void addAd(AdModel ad) {
		ads.add(ad);
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setName(String message){
		this.name = message;
	}
	
	public String getName(){
		return this.name;
	}
}
