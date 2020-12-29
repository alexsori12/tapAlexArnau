package TASCA0_TAP;




import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class MailBox {
    private User user;
    private ArrayList<Message> messageList;
    private MailStore mailStore= null;

    
    public MailBox(User user, MailStore mail) {
        this.user = user;
        this.messageList = null;
        this.mailStore = mail;
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
	    for (Message item : llista) clone.add(new Message(item.getSender(), item.getReceiver(), item.getText(), item.getDate().toString(), item.getSubject()));
	    return clone;
    }

    public void updateMail(MailStore mailstore) { 
    	this.messageList = cloneArray(mailstore.getEmail(user));

    }

    public void listMail() {
    	if(messageList == null) System.out.println("\n    Update your mailbox, and try again ");
    	else {
    		System.out.println("\n Mailbox of: "+user.getUsername());
    		messageList.forEach( Message -> Message.toString());
//    		for (Message item : messageList) {
//    			System.out.println(item.toString());
//    		}
    	}
    }

    public void sendEmail(String usernameDestination, String subject, String text){
    	mailStore.sendEmail(new Message(user.getUsername(), usernameDestination, text, subject));
    }

    public List<Message> getSortedMail(Comparator<Message> m){
    	return messageList.stream().sorted(m).collect(Collectors.toList());

    }

    public List<Message> filterMailBy(Predicate<Message> c){
		return messageList.stream().filter(c).collect(Collectors.toList());
    }
    
    
   
}
