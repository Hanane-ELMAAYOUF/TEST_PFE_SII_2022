package sii.maroc;

public class Ticket {
	private int quantityDishes;
	private int duree;
	
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getQuantityDishes() {
		return quantityDishes;
	}
	public void setQuantityDishes(int quantityDishes) {
		this.quantityDishes = quantityDishes;
	}
	public Ticket and(String string) {
		if(!string.contains("Pizza")) {
			if(new ValidatorOrder(Integer.parseInt(string.substring(0,string.indexOf(" ")))).validateSalad()) {
				
                this.setQuantityDishes(Integer.parseInt(string.substring(0,string.indexOf(" "))));
                this.setDuree(6+3*(this.getQuantityDishes()-1));
				return this;
			}
		
		  else throw new UnvailableDishException();
		}
		else {
			if(new ValidatorOrder(Integer.parseInt(string.substring(0,string.indexOf(" ")))).validatePizza()) {
				this.setQuantityDishes(this.quantityDishes+Integer.parseInt(string.substring(0,string.indexOf(" "))));
                this.setDuree(this.duree+10+5*(Integer.parseInt(string.substring(0,string.indexOf(" ")))-1));
				return this;
			}
			else throw new UnvailableDishException();
			
		}
		
	
	}
    
}
