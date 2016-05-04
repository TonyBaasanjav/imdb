package dao;

import java.util.List;

import org.hibernate.SessionFactory;

import model.movie;

public class movieDAO {

	private SessionFactory sf = hibernateUtil.getSessionFactory();
	
	public movie create(movie a)
	{
		return (movie) sf.getCurrentSession().get(movie.class, a.getId());
	}
	
	public void update(movie a)
	{
		sf.getCurrentSession().saveOrUpdate(a);
	}
	
	public movie getmovie(int id)
	{
		return (movie) sf.getCurrentSession().get(movie.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<movie> getmovies()
	{
		return sf.getCurrentSession().createQuery("select distinct a from movie a").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<movie> searchMovie(String searching,String field)
	{
		return sf.getCurrentSession().createQuery("select m from movie m where "+field+" = '"+searching+"';").list();
	}
}
