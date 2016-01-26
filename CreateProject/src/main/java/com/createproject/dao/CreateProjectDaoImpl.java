package com.createproject.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.createproject.vo.CreateProject;

public class CreateProjectDaoImpl implements ICreateProjectDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean addUserDetail(CreateProject object) {
		boolean status = false;
		Session session = sessionFactory.openSession();
		int id = (Integer) session.save(object);
		if (id == object.getProjectId()) {
			status = true;
			return status;
		} else {
			return false;
		}
	}

}
