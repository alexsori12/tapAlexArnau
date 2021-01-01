package TASCA2_TAP;


import TASCA0_TAP.*;
import java.util.*;


public class MailBox2 extends MailBox {

    private ArrayList<Message> spam;
    private ArrayList<Observer> observersList;

    public ArrayList<Message> getSpam() {
        return spam;
    }

    public void setSpam(ArrayList<Message> spam) {
        this.spam = spam;
    }

    public ArrayList<Observer> getObserversList() {
        return observersList;
    }

    public void setObserversList(ArrayList<Observer> observersList) {
        this.observersList = observersList;
    }

    public MailBox2(User user, MailStore mail) {
        super(user,mail);
        this.observersList = new ArrayList<Observer>();
        this.spam = new ArrayList<Message>();
    }

    public void updateMail(){
        super.updateMail();
        observersList.forEach(Observer -> spam.addAll(Observer.update(this)) );
    }

    public void attach(Observer observer){
        observersList.add(observer);
    }

    public void printSpamList (){
        if(spam.isEmpty()) System.out.println("\t\tSpam List of Mailbox(" + getUser().getUsername()+ ") is Empty" );
        else spam.forEach(Message -> System.out.println( "\t\t"+getUser().getUsername()+ ": " +Message));
    }

    public void printMessagesList (){
        if(this.getMessageList().isEmpty()) System.out.println("\t\tMessage List of Mailbox(" + getUser().getUsername()+ ") is Empty" );
        else this.getMessageList().forEach(System.out::println);
    }

}
