package TASCA0_TAP;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //SALE UN DECORATOR EN ESTA PRACTICA y UN OBSERVER
    	
    	User pedro = new User("nouUSUARI","fede",5);
    	
    	StoreMemory mail = StoreMemory.getInstanceM();
    	
    	Message text = new Message("pepe","juan","hola papa", "SUBJECT");
    	
    	mail.sendEmail( text);
    	mail.getEmail(pedro);

    	
    }
}
