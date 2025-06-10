package org.torresgranadosamaury.pixup.dao.impl;

import org.torresgranadosamaury.pixup.dao.DomicilioDao;
import org.torresgranadosamaury.pixup.hibernate.HibernateUtil;
import org.torresgranadosamaury.pixup.model.Domicilio;
import org.hibernate.Session;

import java.util.List;

public class DomicilioDaoImpl implements DomicilioDao {

    private static DomicilioDao domicilioDao;

    private DomicilioDaoImpl() {

    }

    public static DomicilioDao getInstance(){
        if ( domicilioDao == null )
        {
            domicilioDao = new DomicilioDaoImpl( );
        }
        return domicilioDao;
    }

    @Override
    public List<Domicilio> findAll() {
        List<Domicilio> domicilios = null;
        Session session = HibernateUtil.getSession();
        domicilios = session.createQuery("From Domicilio", Domicilio.class).getResultList();
        session.close();
        return domicilios;
    }

    @Override
    public boolean save(Domicilio domicilio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist( domicilio );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Domicilio domicilio) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge( domicilio );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Domicilio domicilio) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove( domicilio );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Domicilio findById(int id) {
        Session session = HibernateUtil.getSession();
        Domicilio domicilio = session.get(Domicilio.class, id);
        return domicilio;
    }
}
