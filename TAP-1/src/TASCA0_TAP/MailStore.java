package TASCA0_TAP;

import java.util.ArrayList;

public interface MailStore {
	
    public void sendEmail(User receiver, Message text);	
    
    public ArrayList<Message> getEmail(User user);
}
