package TASCA0_TAP;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //SALE UN DECORATOR EN ESTA PRACTICA y UN OBSERVER
    	
    	User pedro = new User("federico","fede",1);
    	
    	StoreFile mail = StoreFile.getInstance();
    	
    	Message text = new Message("pepe","juan","hola papa",1);
    	
    	//mail.sendEmail(pedro, text);
    	mail.getEmail(pedro);

    	
    }
}
