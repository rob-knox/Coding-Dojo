package com.robknox.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date mydate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, 'the' d 'of' MMMM',' yyyy");
		String formattedDate = formatter.format(mydate);
		model.addAttribute("date", formattedDate);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date myTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm aa");
		String formattedTime = formatter.format(myTime);
		model.addAttribute("time", formattedTime);
		
		return "time.jsp";
	}

}
