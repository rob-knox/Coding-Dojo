package com.robknox.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String index(
			@RequestParam(value="firstname", required=false) String firstname,
			@RequestParam(value="lastname", required=false) String lastname
			) {
		if (firstname == null) {
			return "<h1>Hello Human</h1><p>Welcome to Spring Boot!</p>";
		} else {
			return "<h1>Hello " + firstname + " " + lastname + "</h1><p>Welcome to Spring Boot!</p>";
		}
	}
}