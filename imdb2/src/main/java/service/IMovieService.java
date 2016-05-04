package service;

import java.util.HashMap;
import java.util.List;

import model.actor;
import model.movie;

public interface IMovieService {
	movie createMovie(int id, String title, int year, String summary, byte[] poster);
	actor createArtist(String name,String birthPlace, String biography,byte[] picture);
	List<movie> getMovies();
	List<movie> searchMovie(String searching,String field);
	void addComments(int movieId, String comment);
}
