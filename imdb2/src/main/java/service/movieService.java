package service;

import java.util.List;
import org.hibernate.Transaction;

import dao.hibernateUtil;
import dao.actorDAO;
import dao.movieDAO;
import model.actor;
import model.movie;

public class movieService implements IMovieService{
	movieDAO moviedao;
	actorDAO actordao;
	
	public movieService(movieDAO moviedao) {
		super();
		this.moviedao = moviedao;
	}	

	public movie createMovie(int id, String title, int year, String summary, byte[] poster) {
		Transaction tx = hibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		
		movie m = new movie(id,title,year,summary,poster);
		moviedao.create(m);
		
		tx.commit();
		return m;		
	}

	public actor createArtist(String name, String birthPlace, String biography, byte[] picture) {
		Transaction tx = hibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		actor a = new actor(name, birthPlace,biography,picture);
		actordao.create(a);
		tx.commit();
		return a;
	}

	public List<movie> getMovies() {
		return moviedao.getmovies();
	}

	public List<movie> searchMovie(String searching,String field) 
	{
		Transaction tx = hibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		List<movie> a = moviedao.searchMovie(searching,field);
		tx.commit();
		return a;
	}

	public void addComments(int movieId, String comment) {
		Transaction tx = hibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		moviedao.getmovie(movieId).addComment(comment);
		tx.commit();
	}

}
