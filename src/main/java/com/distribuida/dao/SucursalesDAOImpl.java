package com.distribuida.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.distribuida.entities.Sucursales;

@Repository
public class SucursalesDAOImpl implements SucursalesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Sucursales> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Sucursales", Sucursales.class).getResultList();
	}

	@Override
	@Transactional
	public Sucursales findOne(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Sucursales.class, id);
	}

	@Override
	@Transactional
	public void add(Sucursales sucursales) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(sucursales);
	}

	@Override
	@Transactional
	public void up(Sucursales sucursales) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(sucursales);
	}

	@Override
	@Transactional
	public void del(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(findOne(id));
	}

	@Override
	@Transactional
	public List<Sucursales> findAll(String busqueda) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query<Sucursales> query = session.createQuery("SELECT FROM Sucursales au WHERE au.idSucursales =: idSucursales"
				+ "au.sucursal LIKE : busqueda"
				+ "au.descripcion LIKE : busqueda", Sucursales.class);
	
		query.setParameter("busqueda", "%"+busqueda+"%");
				return query.getResultList();
	}

}
