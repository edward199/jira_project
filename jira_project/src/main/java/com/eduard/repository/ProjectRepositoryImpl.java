package com.eduard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eduard.entity.Project;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Project addProject(Project project) {
		em.persist(project);

		em.flush();

		return project;
	}

	@Override
	public List<Project> getProjects() {

		return em.createQuery("From Project").getResultList();
	}

	@Override
	public Project getProjectByProjectKey(String projectKey) {

		Query qry = em.createQuery("From Project p where p.projectKey=:a");

		qry.setParameter("a", projectKey);

		return (Project) qry.getSingleResult();

	}

}
