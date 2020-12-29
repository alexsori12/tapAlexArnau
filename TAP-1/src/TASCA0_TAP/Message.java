package TASCA0_TAP;


import java.util.regex.Pattern;

public class Message {
    private String text;
    private String sender; /* punter ? */
    private String receiver; /* punter ? */
    private int date; /* static incrementanse?*/
    private String subject;
  

	/**
     *  Metode CONSTRUCTOR
     * @param sender -- Usuario que lo envia
     * @param receiver  -- Usuario que lo recibe
     * @param text -- Contingut del missatge
     * @param date -- data del missatge
     * @param subject -- motiu del missatge
     */
   public Message(String sender, String receiver, String text, int date, String subject){
       this.sender = sender;
       this.receiver = receiver;
       this.text = text;
       this.date = date;
       this.subject = subject;
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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getNumberOfWords(){
        String[] words = text.split(Pattern.quote(" "));
        return words.length;
    }
    
    @Override
	public String toString() {
		return "Message: Date ["+date+"] Subject ("+subject+ ") : "+ text+"| From: " + sender + " to: " + receiver;
	}
}
