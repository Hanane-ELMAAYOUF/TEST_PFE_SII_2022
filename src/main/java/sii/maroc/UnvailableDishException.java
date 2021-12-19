package sii.maroc;

public class UnvailableDishException extends RuntimeException{
       public UnvailableDishException() {
    	   super("out of stock");
       }
}
