package TASCA0_TAP;


import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MailSystem {

	private MailStore mail;
    private ArrayList<MailBox> Usermailbox = new ArrayList<MailBox>();
    
    public MailSystem(MailStore mail){
    	this.mail = mail;
    }

    public MailBox addUser(User user){
    	MailBox aux = new MailBox(user, mail);
    	Usermailbox.add(aux);
    	return aux;
    }

	public MailStore getMail() {
		return mail;
	}

	public void setMail(MailStore mail) {
		this.mail = mail;
	}

	public ArrayList<MailBox> getUserMailBox() {
		return Usermailbox;
	}

	public ArrayList<Message> getAllMissages(){
	 	return ( ArrayList<Message>) Usermailbox.stream()
        								.map(MailBox::getMessageList)
        								.flatMap(Collection::stream)
        								.collect(Collectors.toList());
	}

    public ArrayList<User> getAllUsers(){
    	return (ArrayList<User>) Usermailbox.stream()
    								.map(MailBox::getUser)
    								.collect(Collectors.toList());
    }

    public ArrayList<Message> filterMessage(Predicate<Message> m){
        return (ArrayList<Message>) Usermailbox.stream()
        								.map(MailBox::getMessageList)
        								.flatMap(Collection::stream)
        								.filter(m)
        								.collect(Collectors.toList()); 		
    }

    public long numberOfMissages() {
        return	Usermailbox.stream()
        			.map(MailBox::getMessageList)
        			.flatMap(Collection::stream)
        			.count();
    }

    public long averageMessageUser() {
    	return	(Usermailbox.stream()
    			.map(MailBox::getMessageList)
    			.flatMap(Collection::stream)
    			.count())/Usermailbox.size();
        
    }
    
    public ArrayList<Message> groupMessageSubject(String subject){
    	 return (ArrayList<Message>) Usermailbox.stream()
					.map(MailBox::getMessageList)
					.flatMap(Collection::stream)
					.filter(Message -> Message.getSubject().contains(subject))
					.collect(Collectors.toList()); 	
    }

    public long countWordsByUser(User user){
    	
    	return	 Usermailbox.stream()
				 .filter(MailBox -> (MailBox.getUser().equals(user)))
				 .map(MailBox::getMessageList)
				 .flatMap(Collection::stream)
		  		 .mapToInt(Message::getNumberOfWords)
				 .sum();
    }

    public ArrayList<Message> getMessagesB4Year(int year){

		return (ArrayList<Message>) Usermailbox.stream()
				.filter(MailBox -> MailBox.getUser().getYear() < year)
				.map(MailBox::getMessageList)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
	}



}
