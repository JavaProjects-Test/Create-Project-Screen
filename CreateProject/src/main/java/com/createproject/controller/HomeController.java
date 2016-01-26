package com.createproject.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.createproject.service.ICreateProjectService;
import com.createproject.vo.CreateProject;

@Controller
public class HomeController {
	@Autowired
	ICreateProjectService objectCreateProjectService;

	public void setObjectCreateProjectService(
			ICreateProjectService objectCreateProjectService) {
		this.objectCreateProjectService = objectCreateProjectService;
	}

	@RequestMapping("/welcome")
	public ModelAndView homeScreen() {
		ModelAndView mv = new ModelAndView("createproject");

		return mv;
	}

	@RequestMapping(value = "/projectCreated", method = RequestMethod.POST)
	public ModelAndView userSave(
			@RequestParam("projectName") String projectName,
			@RequestParam("date") String date,
			@RequestParam("selectionApplicationForm") String applicationForm,
			@RequestParam("selectionProjectTag") String projectTag,
			@RequestParam("projectDescription") String projectDescription)
			throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MMMMMM/yyyy");
		Date dateObject = dateFormat.parse(date);
		dateFormat.format(dateObject);
		ModelAndView mv;
		CreateProject objectCreateProject = new CreateProject();
		objectCreateProject.setProjectName(projectName);
		objectCreateProject.setDeadlineDate(dateObject);
		objectCreateProject.setApplicationForm(applicationForm);
		objectCreateProject.setProjectTag(projectTag);
		objectCreateProject.setProjectDescription(projectDescription);

		boolean status = objectCreateProjectService
				.addUserDetail(objectCreateProject);

		if (status) {
			mv = new ModelAndView("projectCreated");
			return mv;
		} else {
			mv = new ModelAndView("createproject");
			mv.addObject("messageForProjectName",
					"Project Name is Mandatory field*");
			mv.addObject("messageForDeadlineDate", "Invalid Date*");
			return mv;
		}
	}

}
