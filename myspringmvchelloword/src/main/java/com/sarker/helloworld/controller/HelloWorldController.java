package com.sarker.helloworld.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
// @RequestMapping("/greet")
public class HelloWorldController {
	String message = "Welcome to Spring MVC!";

	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "word") String name) {

		System.out.println("in controller");

		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}

	@RequestMapping("/hi")
	public ModelAndView showMessage2(
			@RequestParam(value = "name", required = false, defaultValue = "word") String name) {

		System.out.println("in controller");

		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", "hi, everyone");
		mv.addObject("name", name);
		return mv;
	}

	@RequestMapping("/welcomepath/{countryName}/{userName}")
	public ModelAndView showMessage3(@PathVariable("userName") String name,
			@PathVariable("countryName") String countryName) {

		System.out.println("in controller");

		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name + "! you are from " + countryName);
		return mv;
	}

	@RequestMapping("/welcomemap/{countryName}/{userName}")
	public ModelAndView showMessage4(@PathVariable Map<String, String> pathVars) {

		System.out.println("in controller Path variable Map");
		String countryName = pathVars.get("countryName");
		String name = pathVars.get("userName");

		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name + "! you are from " + countryName);
		return mv;
	}
}
