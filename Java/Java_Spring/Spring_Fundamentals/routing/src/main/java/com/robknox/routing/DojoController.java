package com.robknox.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("/{info}")
	public String showLesson(@PathVariable("info") String info){
		if(info.equals("dojo")) {
			return "The dojo is awesome!";
		} else if (info.equals("burbank-dojo")) {
			return "Burbank Dojo is located in Southern California";
		} else if (info.equals("san-jose")) {
			return "SJ dojo is the headquarters";
		} else {
			return "None of them hit";
		}
	}

}
