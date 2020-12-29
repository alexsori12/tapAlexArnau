package TASCA0_TAP;

import java.util.ArrayList;
import java.util.Collection;

public class MailBox {
    private User user;
    private ArrayList<Message> messageList;

    public MailBox(User user) {
        this.user = user;
        this.messageList = null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }
    
    public ArrayList<Message> cloneArray(ArrayList<Message> llista){
	    ArrayList<Message> clone = new ArrayList<Message>(llista.size());
	    for (Message item : llista) clone.add(new Message(item.getSender(), item.getReceiver(), item.getText(), item.getDate(), item.getSubject()));
	    return clone;
    }

    public void updateMail(MailStore mailstore) { 
    	this.messageList = cloneArray(mailstore.getEmail(user));

    }

    public void listMail() {
    	if(messageList == null) System.out.println("\n    Update your mailbox, and try again ");
    	else {
    		System.out.println("\n Mailbox of: "+user.getUsername());
    		for (Message item : messageList) {
    			System.out.println(item.toString());
    		}
    	}
    }

    public void sendEmail(){
    }

    public void getSortedMail(){

    }

    public void filterMailBy(){

    }
    
    
   
}
