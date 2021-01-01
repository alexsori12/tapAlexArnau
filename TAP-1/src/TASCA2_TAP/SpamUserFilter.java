package TASCA2_TAP;

import TASCA0_TAP.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SpamUserFilter extends Observer {


    @Override
    public ArrayList<Message> update(MailBox val) {

        ArrayList<Message> spam = (ArrayList<Message>) val.getMessageList().stream().filter(message -> message.getSender().contains(("spam"))).collect(Collectors.toList());
        spam.forEach(Message -> val.getMessageList().remove(Message));
        return spam;
    }

}
