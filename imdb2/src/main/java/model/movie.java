package model;

import java.util.*;

import javax.persistence.*;

@Entity
public class movie {

	@Id
	@GeneratedValue
	private int id;
	private String title;
	private int year;
	private String summary;
	@Lob
	private byte[] poster;
	
	public movie(int id, String title, int year, String summary, byte[] poster) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.summary = summary;
		this.poster = poster;
	}


	@OneToMany
	Collection<String> comments = new ArrayList<String>();
	public void addComment(String comment)
	{
		comments.add(comment);
	}
	@OneToOne
	Collection<actor> chars = new ArrayList<actor>();
	public void addActor(actor a)
	{
		chars.add(a);
	}
	@OneToMany
	Collection<String> genres = new ArrayList<String>();
	public void addGenres(String a)
	{
		genres.add(a);
	}
	@OneToMany
	Collection<String> directors = new ArrayList<String>();
	public void addDirectors(String a)
	{
		directors.add(a);
	}
	@OneToMany
	Collection<Integer> ratings = new ArrayList<Integer>();
	public void addRatings(int a)
	{
		ratings.add(a);
	}
	
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public byte[] getPoster() {
		return poster;
	}


	public void setPoster(byte[] poster) {
		this.poster = poster;
	}


	public Collection<String> getComments() {
		return comments;
	}


	public void setComments(Collection<String> comments) {
		this.comments = comments;
	}


	public Collection<actor> getChars() {
		return chars;
	}


	public void setChars(Collection<actor> chars) {
		this.chars = chars;
	}


	public Collection<String> getGenres() {
		return genres;
	}


	public void setGenres(Collection<String> genres) {
		this.genres = genres;
	}


	public Collection<String> getDirectors() {
		return directors;
	}


	public void setDirectors(Collection<String> directors) {
		this.directors = directors;
	}

	public Collection<Integer> getRatings() {
		return ratings;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chars == null) ? 0 : chars.hashCode());
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((directors == null) ? 0 : directors.hashCode());
		result = prime * result + ((genres == null) ? 0 : genres.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Arrays.hashCode(poster);
		result = prime * result + ((ratings == null) ? 0 : ratings.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		movie other = (movie) obj;
		if (chars == null) {
			if (other.chars != null)
				return false;
		} else if (!chars.equals(other.chars))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (directors == null) {
			if (other.directors != null)
				return false;
		} else if (!directors.equals(other.directors))
			return false;
		if (genres == null) {
			if (other.genres != null)
				return false;
		} else if (!genres.equals(other.genres))
			return false;
		if (id != other.id)
			return false;
		if (!Arrays.equals(poster, other.poster))
			return false;
		if (ratings == null) {
			if (other.ratings != null)
				return false;
		} else if (!ratings.equals(other.ratings))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return title;
	}
}
