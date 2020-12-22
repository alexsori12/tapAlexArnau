package TASCA0_TAP;

import java.util.ArrayList;
import java.util.Collection;

public class MailBox {
    private User user;
    private ArrayList<Message> messageList;

    public MailBox(User user) {
        this.user = user;
        this.messageList = new ArrayList<Message>();
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

    public void updateMail(MailStore mailstore) {

    }

    public void listMail() {

    }

    public void sendEmail(){
    }

    public void getSortedMail(){

    }

    public void filterMailBy(){

    }
}
