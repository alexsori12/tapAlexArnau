package TASCA0_TAP;




import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class MailBox {
    private User user;
    private ArrayList<Message> messageList;
    private MailStore mailStore= null;

    
    public MailBox(User user, MailStore mail) {
        this.user = user;
        this.messageList = new ArrayList<Message>();
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
	    for (Message item : llista) clone.add(new Message(item.getSender(), item.getReceiver(), item.getText(), item.getDate(), item.getSubject()));
	    return clone;
    }

    public void updateMail() {
    	this.messageList = cloneArray(mailStore.getEmail(user));

    }

    public ArrayList<Message> listMail() {
    	if(messageList.isEmpty())
    	    System.out.println("\n    Update your mailbox, and try again ");
    	else
    		System.out.println("\n Mailbox of: "+user.getUsername());

        return messageList;
    }

    public void sendEmail(String usernameDestination, String subject, String text){
    	mailStore.sendEmail(new Message(user.getUsername(), usernameDestination, text, subject));
    }

    public ArrayList<Message> getSortedMail(Comparator<Message> m){
    	return (ArrayList<Message>) messageList.stream().sorted(m).collect(Collectors.toList());

    }

    public ArrayList<Message> filterMailBy(Predicate<Message> c){
		return (ArrayList<Message>) messageList.stream().filter(c).collect(Collectors.toList());
    }
    
    
   
}
