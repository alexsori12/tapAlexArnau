package TASCA0_TAP;

import java.util.Date;

public class Message {
    private String text;
    private User sender; /* punter ? */
    private User receiver; /* punter ? */
    private Date date; /* static incrementanse?*/
    private String subject;

  

	/**
     *  Metode CONSTRUCTOR
     * @param sender -- Usuario que lo envia
     * @param receiver  -- Usuario que lo recibe
     * @param text -- Contingut del missatge
     * @param subject -- Tema de la conversació
     * @param date -- data del missatge
     */
   public Message(User sender, User receiver, String text,String subject, Date date){
       this.sender = sender;
       this.receiver = receiver;
       this.text = text;
       this.subject = subject;
       this.date = date;
   }
   
   public String getSubject() {
 		return subject;
 	}

 	public void setSubject(String subject) {
 		this.subject = subject;
 	}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
