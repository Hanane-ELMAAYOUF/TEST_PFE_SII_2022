package sii.maroc;

import java.util.Arrays;
import java.util.List;

import javax.xml.validation.Validator;

public class Restaurant {
	static  int   MozzarellaInStock,tomatoeInStock,flourInStock;
    Ticket ticket=new Ticket();
	public Restaurant(String string, String string2, String string3, String string4) {
		MozzarellaInStock=Integer.parseInt(string.substring(0,string.indexOf(" ")));
		tomatoeInStock=Integer.parseInt(string2.substring(0,string2.indexOf(" ")));
	}

	public Restaurant(String string, String string2, String string3, String string4, String string5, String string6) {
		List<String> l=Arrays.asList(string,string2,string3,string4,string5,string6);
		for(String s:l) {
			if(s.contains("balls Mozzarella"))MozzarellaInStock=Integer.parseInt(s.substring(0,s.indexOf(" ")));
			if(s.contains("tomatoes"))tomatoeInStock=Integer.parseInt(s.substring(0,s.indexOf(" ")));
			if(s.contains("Flour"))flourInStock=Character.getNumericValue(s.charAt(0));
		}
		
		
	}

	public Ticket order(String string) throws UnvailableDishException {
		if(!string.contains("Pizza")) {
			if(new ValidatorOrder(Integer.parseInt(string.substring(0,string.indexOf(" ")))).validateSalad()) {
				
				ticket.setQuantityDishes(Integer.parseInt(string.substring(0,string.indexOf(" "))));
				ticket.setDuree(6+3*(ticket.getQuantityDishes()-1));
				return ticket;
			}
		
		  else throw new UnvailableDishException();
		}
		else {
			if(new ValidatorOrder(Integer.parseInt(string.substring(0,string.indexOf(" ")))).validatePizza()) {
				ticket.setQuantityDishes(Integer.parseInt(string.substring(0,string.indexOf(" "))));
				ticket.setDuree(10+5*(ticket.getQuantityDishes()-1));
				return ticket;
			}
			else throw new UnvailableDishException();
		}
	}

	public Meal retrieve(Ticket ticket) {
		Meal meal=new Meal();
		meal.setDuration(ticket.getDuree());
		meal.setNumber(ticket.getQuantityDishes());
		return meal;
	}


	
}
