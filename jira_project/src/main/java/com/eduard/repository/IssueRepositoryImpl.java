package com.eduard.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.eduard.entity.Issue;

@Repository
public class IssueRepositoryImpl implements IssueRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Issue addIssue(Issue issue) {
		em.persist(issue);

		em.flush();

		return issue;
	}

	@Override
	public List<Issue> getIssues(int projectId) {

		Query qry = em.createQuery("from Issue i where i.projectId=:a");

		qry.setParameter("a", projectId);

		return qry.getResultList();
	}

	@Override
	public List<Issue> getAllIssues() {

		Query qry = em.createQuery("from Issue i");

		List<Issue> issues = qry.getResultList();

		return issues;

	}
}
