package com.createproject.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.createproject.dao.ICreateProjectDao;
import com.createproject.vo.CreateProject;

@Service
public class CreateProjectServiceImpl implements ICreateProjectService {

	ICreateProjectDao objectCreateProjectDao;

	public void setObjectCreateProjectDao(
			ICreateProjectDao objectCreateProjectDao) {
		this.objectCreateProjectDao = objectCreateProjectDao;
	}

	public boolean addUserDetail(CreateProject object) {
		Date date = new Date();
		boolean status = false;
		if (object.getProjectName().isEmpty()) {
			return false;
		} else if (object.getDeadlineDate().before(date)) {
			return false;
		} else {

			status = objectCreateProjectDao.addUserDetail(object);
			return status;
		}
	}

}
