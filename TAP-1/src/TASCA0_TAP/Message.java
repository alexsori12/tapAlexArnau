package TASCA0_TAP;



public class Message {
    private String text;
    private String sender; /* punter ? */
    private String receiver; /* punter ? */
    private int date; /* static incrementanse?*/

  

	/**
     *  Metode CONSTRUCTOR
     * @param sender -- Usuario que lo envia
     * @param receiver  -- Usuario que lo recibe
     * @param text -- Contingut del missatge
     * @param date -- data del missatge
     */
   public Message(String sender, String receiver, String text, int date){
       this.sender = sender;
       this.receiver = receiver;
       this.text = text;
       this.date = date;
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
}
