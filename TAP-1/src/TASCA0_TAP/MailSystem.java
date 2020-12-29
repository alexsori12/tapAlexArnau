package TASCA0_TAP;


import java.util.ArrayList;

public class MailSystem {

	private MailStore mail;
    private static final ArrayList<MailBox> Usermailbox = new ArrayList<>();
    
    public MailSystem(MailStore mail){
    	this.mail = mail;
    }

    public void addUser(User user){Usermailbox.add(new MailBox(user, mail));}

    public ArrayList<Message> getAllMissages(){
        ArrayList<Message> returned= new ArrayList<Message>();
        for(MailBox m: Usermailbox)
        {
            ArrayList<Message> allMessage = m.getMessageList();
            returned.addAll(allMessage);
        }
        return returned;
    }

    public ArrayList<User> getAllUsers(){
        ArrayList<User> returned = new ArrayList<User>();
        for(MailBox m: Usermailbox) returned.add(m.getUser());
        return returned;
    }

    public ArrayList<Message> filterMessage(){
        ArrayList<Message> returned= new ArrayList<Message>();
        return returned;
    }

    public int numberOfMissages() {
        int cont=0;
        for (MailBox m : Usermailbox) {
            ArrayList<Message> MList = m.getMessageList();
            for(Message mm : MList) cont++;
        }
        return cont;
    }

    public int averageMessageUser() {
        int allMessages = numberOfMissages();
        ArrayList<User> users = getAllUsers();
        int allUsers=0;
        for(User u : users) allUsers++;
        return (allMessages/allUsers);
    }

    public int countWordsByUser(User user){
        int words=0;
        for(MailBox m : Usermailbox){
            if(m.getUser().equals(user)){
                for(Message mm : m.getMessageList()){
                    words+=mm.getNumberOfWords();
                }
            }
        }
        return words;
    }

    public ArrayList<Message> getMessagesB4Year(int year){
        ArrayList<Message> returned= new ArrayList<Message>();
        for(MailBox m : Usermailbox){
            if(m.getUser().getYear() < year){
                for(Message mm : m.getMessageList()) returned.add(mm);
            }
        }
        return returned;
    }



}
