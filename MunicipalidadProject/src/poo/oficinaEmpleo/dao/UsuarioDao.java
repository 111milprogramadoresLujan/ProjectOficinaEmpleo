/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.oficinaEmpleo.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import poo.OficinaEmpleoEntity.Usuario;

/**
 *
 * @author Acer
 */

public class UsuarioDao {
    
   
     private final SessionFactory sessionFactory;

    public UsuarioDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void GuardarUsuario(Usuario usuario)
    {
        Session session = sessionFactory.openSession();
        
        Transaction tx = null;
      try {
          
            tx = session.beginTransaction();
            
            session.save(usuario);
            tx.commit();
        
         } 
      catch (HibernateException e) 
      {
       if (tx != null) tx.rollback();
         e.printStackTrace(); 
      }
      finally 
      {
         session.close(); 
      }
    }
    
    
}
