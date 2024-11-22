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
public class TeamService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public TeamService() {}
	
	public Long insertarTeam(Team team) {		//CAMBIO: DEBÍA DEVOLVER ID
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		Long id = null;
		try {
			transaction = session.beginTransaction();
			session.persist(team);
			id = team.getId();
			transaction.commit();
			
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return id;
	}
	
	public void borrarTeam(Team team) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		
		Team teamRecuperado = session.get(Team.class, team.getId());
		
		try {
			transaction = session.beginTransaction();
			session.delete(teamRecuperado);
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
	
	public void actualizarTeam(Long id, String name, String factory) {
		Session session = sessionFactory.openSession();
		
		Team team = session.get(Team.class, id);
		team.setName(name);
		team.setFactory(factory);
		
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.merge(team);
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
	
	public Team obtenerTeam(Long id) {
		Session session = sessionFactory.openSession();
		
		Team team = null;
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			team = session.get(Team.class, id);
			transaction.commit();
			
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return team;
	}
	
public List<Team> obtenerNombresTeams(String factory){
		
		Session session = sessionFactory.openSession();
		List<Team> teams = null;
		
		try {
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			
			CriteriaQuery<Team> criteriaQuery = criteriaBuilder.createQuery(Team.class);
			
			Root<Team> root = criteriaQuery.from(Team.class);
			
			//CAMBIO PRIMER ARGUMENTO
			criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("factory"), factory));
			
			teams = session.createQuery(criteriaQuery).getResultList();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return teams;
	}

		
}
