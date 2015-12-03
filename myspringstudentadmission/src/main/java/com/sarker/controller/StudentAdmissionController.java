package com.sarker.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sarker.beans.Student;
import com.sarker.validator.StudentNameEditor;

@Controller
public class StudentAdmissionController {

	public StudentAdmissionController() {
		System.out.println("Controller constructor");
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		 //disallow field
		binder.setDisallowedFields(new String[] { "studentMobile" });
		

		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy****MM****dd");
		// binder.registerCustomEditor(Date.class, "studentDOB",
		// new CustomDateEditor(sdf, false));

		binder.registerCustomEditor(String.class, "studentName",
				new StudentNameEditor());

	}

	@RequestMapping(value = "/admissionFrom.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		System.out.println("/admissionFrom");
		ModelAndView mv = new ModelAndView("AdmissionFrom");
		return mv;

	}

	@ModelAttribute
	public void addingCommonObjects(Model model1) {
		model1.addAttribute("headerMessage",
				"Ayub Ali Sarker College of Engineering, Bangladesh");
	}

	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(
			@RequestParam(value = "studentName", defaultValue = "Mr Ayub Ali Sarker") String name,
			@RequestParam("studentHobby") String hobby) {
		ModelAndView mv = new ModelAndView("AdmissionSuccess");
		mv.addObject("msg", "Details submitted by you Name: " + name
				+ ", your hobby is " + hobby);
		return mv;

	}

	@RequestMapping(value = "/map/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionFormap(
			@RequestParam Map<String, String> reqparMap) {

		String name = reqparMap.get("studentName");
		String hobby = reqparMap.get("studentHobby");
		ModelAndView mv = new ModelAndView("AdmissionSuccess");
		mv.addObject("msg", "Details submitted by you Name: " + name
				+ ", your hobby is " + hobby);
		return mv;

	}

	@RequestMapping(value = "/submitAdmissionFormModelAttribute1.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionFormModelAttribute1(
			@RequestParam(value = "studentName", defaultValue = "Mr Ayub Ali Sarker") String name,
			@RequestParam("studentHobby") String hobby) {

		Student student1 = new Student();
		student1.setStudentName(name);
		student1.setStudentHobby(hobby);

		ModelAndView mv = new ModelAndView("AdmissionSuccess");
		mv.addObject("headerMessage",
				"Ayub Ali Sarker College of Engineering Bangladesh");
		mv.addObject("student1", student1);
		return mv;

	}

	@RequestMapping(value = "/submitAdmissionFormModelAttribute2.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionFormModelAttribute2(
			@Valid @ModelAttribute("student1") Student student1,
			BindingResult result) {
		if (result.hasErrors()) {
			ModelAndView mv = new ModelAndView("AdmissionFrom");
			return mv;
		}
		System.out.println("student1: " + student1);
		ModelAndView mv = new ModelAndView("AdmissionSuccess");
		return mv;

	}
}
