package controller;

import java.util.Collection;

import org.hibernate.Transaction;

import service.*;
import dao.hibernateUtil;

public class App {

    public static void main(String[] args) {
        try {
        	
            IMovieService ms = new movieService(null);
            
            

        } catch (RuntimeException e) {
            Transaction tx = hibernateUtil.getSessionFactory()
                    .getCurrentSession().getTransaction();
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace(System.err);
        }
        System.exit(0);

    }

}
