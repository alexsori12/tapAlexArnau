package TASCA0_TAP;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //SALE UN DECORATOR EN ESTA PRACTICA y UN OBSERVER
    	
    	User pedro = new User("nouUSUARI","fede",5);
    	
    	StoreFile mail = StoreFile.getInstance();
    	
    	Message text = new Message("pepe","juan","hola papa",1, "SUBJECT");
    	
    	mail.sendEmail(pedro, text);
    	mail.getEmail(pedro);

    	
    }
}
