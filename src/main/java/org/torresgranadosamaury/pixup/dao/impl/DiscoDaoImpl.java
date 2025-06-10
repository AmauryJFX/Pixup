package org.torresgranadosamaury.pixup.dao.impl;

import org.torresgranadosamaury.pixup.dao.DiscoDao;
import org.torresgranadosamaury.pixup.hibernate.HibernateUtil;
import org.torresgranadosamaury.pixup.model.Disco;
import org.hibernate.Session;

import java.util.List;

public class DiscoDaoImpl implements DiscoDao {

    private static DiscoDao discoDao;

    private DiscoDaoImpl() {

    }

    public static DiscoDao getInstance(){
        if ( discoDao == null )
        {
            discoDao = new DiscoDaoImpl( );
        }
        return discoDao;
    }

    @Override
    public List<Disco> findAll() {
        List<Disco> discos = null;
        Session session = HibernateUtil.getSession();
        discos = session.createQuery("From Disco", Disco.class).getResultList();
        session.close();
        return discos;
    }

    @Override
    public boolean save(Disco disco) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist( disco );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Disco disco) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge( disco );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Disco disco) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove( disco );
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Disco findById(int id) {
        Session session = HibernateUtil.getSession();
        Disco disco = session.get(Disco.class, id);
        return disco;
    }
}

