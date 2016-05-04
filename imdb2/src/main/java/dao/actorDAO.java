package dao;

import java.util.List;

import org.hibernate.SessionFactory;

import model.actor;

public class actorDAO {

	private SessionFactory sf = hibernateUtil.getSessionFactory();
	
	public actor create(actor a)
	{
		return (actor) sf.getCurrentSession().get(actor.class, a.getId());
	}
	
	public void update(actor a)
	{
		sf.getCurrentSession().saveOrUpdate(a);
	}
	
	public actor getActor(int id)
	{
		return (actor) sf.getCurrentSession().get(actor.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<actor> getActors()
	{
		return sf.getCurrentSession().createQuery("select distinct a from actor a " +
				"join fetch a.movies_chars ").list();
	}
	
}
