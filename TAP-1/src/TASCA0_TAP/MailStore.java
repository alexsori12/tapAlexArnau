package TASCA0_TAP;


public interface MailStore {
    public void sendEmail(User receiver,Message text);	
    public void getEmail(User user);
}
