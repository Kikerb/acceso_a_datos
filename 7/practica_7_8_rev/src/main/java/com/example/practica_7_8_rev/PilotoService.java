package com.example.practica_7_8_rev;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


@Service
public class PilotoService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public PilotoService() {}
	
	public Long insertarPiloto(Piloto piloto) {	//CAMBIO, DEVUELVE ID
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.persist(piloto);
			transaction.commit();
			
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return piloto.getId();
	}
	
	public void borrarPiloto(Piloto piloto) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		Piloto pilotoRecuperado = session.get(Piloto.class, piloto.getId());
		
		try {
			transaction = session.beginTransaction();
			session.delete(pilotoRecuperado);
			transaction.commit();
			
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void actualizarPiloto(Long id, String name) {
		Session session = sessionFactory.openSession();
		
		Piloto piloto = session.get(Piloto.class, id);
		piloto.setName(name);
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.merge(piloto);
			transaction.commit();
			
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	public Piloto obtenerPiloto(Long id) {
		Session session = sessionFactory.openSession();
		
		Piloto piloto = null;
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			piloto = session.get(Piloto.class, id);
			transaction.commit();
			
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return piloto;
	}
	
	public List<Piloto> obtenerNombresPilotos(String name){
		
		Session session = sessionFactory.openSession();
		List<Piloto> pilotos = null;
		
		try {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			
			CriteriaQuery<Piloto> criteriaQuery = criteriaBuilder.createQuery(Piloto.class);
			
			Root<Piloto> root = criteriaQuery.from(Piloto.class);
			
			//CAMBIO, PRIMER PARÁMETRO
			criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
			
			pilotos = session.createQuery(criteriaQuery).getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return pilotos;
	}
		
}
