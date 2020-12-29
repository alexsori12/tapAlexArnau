package TASCA0_TAP;

import java.util.*;


public class StoreMemory implements MailStore {
	
	private static StoreMemory instance = null;

	private Hashtable<String, ArrayList<Message> > hash; 
   

    private StoreMemory() {
        hash = new Hashtable<String, ArrayList<Message>>();
    }

    public static StoreMemory getInstanceM() {
        if (instance == null) {
            instance = new StoreMemory();
        }
        return instance;
    }
    

    @Override
    public void sendEmail(User receiver, Message text) {
    	if( hash.get(receiver.getUsername()) != null) {
    		hash.put(receiver.getUsername(), new ArrayList<Message>());
    	}
    		hash.get(receiver.getUsername()).add(text);
    }

    @Override
    public ArrayList<Message> getEmail(User user) {
    	return hash.get(user.getUsername());
    }
}
