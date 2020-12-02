package TASCA0_TAP;

import java.util.ArrayList;

public class UserList {
    private User user;

    private ArrayList<Message> messageList; public UserList(User user) {
        this.user = user;
        this.messageList = new ArrayList<Message>();;
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


}
