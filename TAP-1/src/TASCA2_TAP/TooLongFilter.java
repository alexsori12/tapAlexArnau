package TASCA2_TAP;


import TASCA0_TAP.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class TooLongFilter extends Observer {

    @Override
    public ArrayList<Message> update(MailBox val) {
        ArrayList<Message> tooLong = (ArrayList<Message>) val.getMessageList().stream().filter(message -> message.getText().length() > 20).collect(Collectors.toList());
        tooLong.forEach(Message -> val.getMessageList().remove(Message));
        return tooLong;
    }
}
