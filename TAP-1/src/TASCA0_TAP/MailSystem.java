package TASCA0_TAP;

import java.util.ArrayList;

public class MailSystem {

    private ArrayList<MailBox> Usermailbox;

    public MailSystem(){};

    public void addUser(User user){Usermailbox.add(new MailBox(user));}

    public ArrayList<Message> getAllMissages(){
        ArrayList<Message> returned;
        for(MailBox m: Usermailbox)
            for()
    }

}
