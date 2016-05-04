package model;

import java.util.*;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class actor {
	
	public actor(String name, String birthPlace, String biography,byte[] picture) {
		super();
		this.name = name;
		this.birthPlace = birthPlace;
		this.biography = biography;
		this.picture = picture;
	}
	
	@Id
	@GeneratedValue
	private int id;
	public int getId() {
		return id;
	}

	private String name;
	private String birthPlace;
	private String biography;
	@Lob
	private byte[] picture;

	@OneToMany 
	Map<String,String> movies_chars = new HashMap<String,String>();
	
	public Map<String, String> getMovies_chars() {
		return movies_chars;
	}

	public void add_movies_chars(String movie_name,String char_name)
	{
		movies_chars.put(movie_name, char_name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	
}
