package com.robknox.ninjagoldgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "redirect:/gold";
	}
	@RequestMapping("/gold")
	public String gold(HttpSession session) {
		Integer gold = (Integer) session.getAttribute("gold");
		if(gold == null) {
			session.setAttribute("gold", 0);
		}
		List<String> messages = (List<String>) session.getAttribute("messages");
		if(messages == null) {
			session.setAttribute("messages", new ArrayList<String>());			
		}
		return "gold.jsp";
	}
	@RequestMapping(value="/farm", method=RequestMethod.POST)
	public String farm(HttpSession session) {
		Random rand = new Random();
		List<String> messages = (List<String>) session.getAttribute("messages");
		Integer gold = (Integer) session.getAttribute("gold");
		Integer n = rand.nextInt(20) + 10; 
		gold += n;
		session.setAttribute("gold", gold);
		messages.add("You entered a farm and earned " + n + " gold.");
		session.setAttribute("messages", messages);
		
		return "redirect:/gold";
	}
	@RequestMapping(value="/cave", method=RequestMethod.POST)
	public String cave(HttpSession session) {
		Random rand = new Random();
		List<String> messages = (List<String>) session.getAttribute("messages");
		Integer gold = (Integer) session.getAttribute("gold");
		Integer n = rand.nextInt(10) + 5; 
		gold += n;
		session.setAttribute("gold", gold);
		messages.add("You entered a cave and earned " + n + " gold.");
		session.setAttribute("messages", messages);
		return "redirect:/gold";
	}
	@RequestMapping(value="/house", method=RequestMethod.POST)
	public String house(HttpSession session) {
		Random rand = new Random();
		List<String> messages = (List<String>) session.getAttribute("messages");
		Integer gold = (Integer) session.getAttribute("gold");
		Integer n = rand.nextInt(5) + 2; 
		gold += n;
		session.setAttribute("gold", gold);
		messages.add("You entered a house and earned " + n + " gold.");
		session.setAttribute("messages", messages);
		return "redirect:/gold";
	}
	@RequestMapping(value="/casino", method=RequestMethod.POST)
	public String casino(HttpSession session) {
		Random rand = new Random();
		String change = "";
		String ouch = "";
		List<String> messages = (List<String>) session.getAttribute("messages");
		Integer gold = (Integer) session.getAttribute("gold");
		Integer e = rand.nextInt(50);
		Integer t = rand.nextInt(2) + 1;
		if (t == 2) {
			gold += e;
			change = "earned";
			ouch = "";
			System.out.println(t);
		} else if (t == 1) {
			gold -= e;
			change = "lost";
			ouch = "ouch!";
			System.out.println(t);
		}
		if (gold < 0) {
			gold = 0;
		}
		session.setAttribute("gold", gold);
		messages.add("You entered a casino and " + change + " " + e + " gold." + ouch);
		session.setAttribute("messages", messages);
		//System.out.println(t + " Earnings: " + e);
		
		return "redirect:/gold";
	}

}