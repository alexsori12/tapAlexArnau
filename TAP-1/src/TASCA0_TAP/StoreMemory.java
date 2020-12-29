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
    public void sendEmail( Message text) {
    	if( hash.get(text.getReceiver()) != null) {
    		hash.put(text.getReceiver(), new ArrayList<Message>());
    	}
    		hash.get(text.getReceiver()).add(text);
    }

    @Override
    public ArrayList<Message> getEmail(User user) {
    	return hash.get(user.getUsername());
    }
}
