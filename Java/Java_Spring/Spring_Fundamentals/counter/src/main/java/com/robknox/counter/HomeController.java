package com.robknox.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if (count == null || count.equals("")) {
			session.setAttribute("count", 0);
		} else {
			session.setAttribute("count", count += 1);
		}
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter() {
		
		return "counter.jsp";
	}
	@RequestMapping("/plustwo")
	public String plustwo(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if (count == null || count.equals("")) {
			session.setAttribute("count", 0);
		} else {
			session.setAttribute("count", count += 2);
		}
		return "third.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return  "redirect:/";
	}
}
