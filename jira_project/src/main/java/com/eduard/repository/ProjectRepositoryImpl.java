package com.eduard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

		List<Project> projects = em.createQuery("From Project").getResultList();

		return projects;
	}

}
