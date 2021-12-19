package sii.maroc;

class ValidatorOrder {
	int numberOfDishes;
  public ValidatorOrder(int numberOfDishes) {
	  this.numberOfDishes=numberOfDishes;
  }
  public boolean validateSalad() {
	  if(this.numberOfDishes<=Restaurant.MozzarellaInStock && numberOfDishes<=Restaurant.tomatoeInStock/2)
	  return true ;
	  else return false;
  }
  public boolean validatePizza() {
	  if(this.numberOfDishes<=Restaurant.MozzarellaInStock && numberOfDishes<=Restaurant.tomatoeInStock/4 &&numberOfDishes<=Restaurant.flourInStock*1000/300)
	  return true ;
	  else return false;
  }
}
