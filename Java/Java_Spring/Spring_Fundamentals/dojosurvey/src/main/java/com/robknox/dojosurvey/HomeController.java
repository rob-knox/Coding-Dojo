package com.robknox.dojosurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/survey", method=RequestMethod.POST)
	public String survey(
			@RequestParam(value="name") String name,
			@RequestParam(value="location") String location,
			@RequestParam(value="language") String language,
			@RequestParam(value="comment") String comment,
			HttpSession session) {
		//System.out.println("Name: " + name + " Location: " + location + " Language: " + language + " Comment: " + comment);
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		if (language.equals("Java")) {
			return "redirect:/java";
		}
		return "redirect:/result";
	}
	@RequestMapping("/result")
	public String result() {
		return "result.jsp";
	}
	@RequestMapping("/java")
	public String java() {
		return "java.jsp";
	}
}
