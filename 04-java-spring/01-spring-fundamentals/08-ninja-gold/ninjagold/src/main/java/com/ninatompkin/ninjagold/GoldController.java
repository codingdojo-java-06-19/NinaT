package com.ninatompkin.ninjagold;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.internal.util.privilegedactions.NewSchema;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

@RequestMapping("/gold")
public class GoldController {

	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("gold")==null) {
			reset(session);
		}
		
		Integer gold = (Integer)session.getAttribute("gold");
		model.addAttribute("gold", gold);
		model.addAttribute("activities", session.getAttribute("activities"));
		System.out.println("Our current gold count is "+ gold);
		return "index.jsp";
	}
	
	private void reset(HttpSession session) {
		ArrayList<String> activityList = new ArrayList<String>();
		System.out.println("No gold detected...intializing gold");
		Integer gold = 0;
		session.setAttribute("gold", gold);
		session.setAttribute("activities", activityList);
	}
	
	@RequestMapping(value="/addGold", method=RequestMethod.POST)
	public String addGold(@RequestParam(value="location") String location, HttpSession session) {
		
		Integer gold = (Integer)session.getAttribute("gold");
		@SuppressWarnings("unchecked")
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		String formattedDate = formatDate();
		if (location.equals("farm")) {
			int addGold = randomGold(10,20);
			int updatedGold = gold+addGold;
			session.setAttribute("gold", updatedGold);
			System.out.println("You entered a "+location+" and earned "+ addGold+" gold. ("+formattedDate+")");
			activities.add("You entered a "+location+" and earned "+ addGold+" gold. ("+formattedDate+")");
		}
		else if (location.equals("cave")) {
			int addGold = randomGold(5,10);
			int updatedGold = gold+addGold;
			session.setAttribute("gold", updatedGold);
			System.out.println("You entered a "+location+" and earned "+ addGold+" gold. ("+formattedDate+")");
			activities.add("You entered a "+location+" and earned "+ addGold+" gold. ("+formattedDate+")");
		}
		else if (location.equals("house")){
			int addGold = randomGold(2,5);
			int updatedGold = gold+addGold;
			session.setAttribute("gold", updatedGold);
			System.out.println("You entered a "+location+" and earned "+ addGold+" gold. ("+formattedDate+")");
			activities.add("You entered a "+location+" and earned "+ addGold+" gold. ("+formattedDate+")");
		}
		else {
			int addGold = randomGold(-50,50);
			int updatedGold = gold+addGold;
			session.setAttribute("gold", updatedGold);
			System.out.println("You entered a "+location+" and earned "+ addGold+" gold. ("+formattedDate+")");
			if (addGold > 0) {
				activities.add("You entered a "+location+" and earned "+ addGold+" gold. ("+formattedDate+")");
			}
			else {
				activities.add("You entered a "+location+" and lost "+ addGold +" gold. Ouch. ("+formattedDate+")");
			}
		}
		
		return "redirect:/gold/";
	}
	
	private String formatDate() {
		Calendar cal = Calendar.getInstance();
		String formattedMDY = getDateInOrdinalFormat(cal);
		
		Date date = new Date();
		long ts = 1022895271767L;
		SimpleDateFormat format = new SimpleDateFormat("h:mm a");
		DateFormatSymbols symbols = new DateFormatSymbols(Locale.getDefault());
		symbols.setAmPmStrings(new String[] { "am", "pm" });
		format.setDateFormatSymbols(symbols);
		String formattedTime = format.format(ts);
		
		String formattedDate = formattedMDY+" "+formattedTime;
		return formattedDate;
	}
	
	private String getDateInOrdinalFormat(Calendar currentCalDate) {
	    String dayNumberSuffix = getDayNumberSuffix(currentCalDate.get(Calendar.DAY_OF_MONTH));
	    DateFormat dateFormat = new SimpleDateFormat("MMMM d'" + dayNumberSuffix + "' yyyy");
	    return dateFormat.format(currentCalDate.getTime());
	}

	private String getDayNumberSuffix(int day) {
	    if (day >= 11 && day <= 13) {
	        return "th";
	    }
	    switch (day % 10) {
	    case 1:
	        return "st";
	    case 2:
	        return "nd";
	    case 3:
	        return "rd";
	    default:
	        return "th";
	    }
	}
	
	private int randomGold(int lowNum, int highNum) {
		Random rand = new Random();
		int random = (int)rand.nextInt((highNum - lowNum)+1)+lowNum;
		return random;
	}
	

}
