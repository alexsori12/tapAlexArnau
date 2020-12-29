package TASCA0_TAP;

import java.util.ArrayList;

public interface MailStore {
	
    public void sendEmail(Message text);	
    
    public ArrayList<Message> getEmail(User user);
}
