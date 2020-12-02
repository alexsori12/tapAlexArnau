package TASCA0_TAP;

import java.util.ArrayList;
import java.util.List;

public class StoreMemory implements MailStore {

    private static ArrayList<UserList> UserList=null;

    public static List<TASCA0_TAP.UserList> StoreFile() {
        if(UserList == null) UserList = new ArrayList<UserList>();
        return UserList;
    }

    @Override
    public void sendEmail(User receiver, Message text) {
        boolean trobat=false;
        for(int i=0; i < UserList.size() && !trobat;i++) {
            if(UserList.get(i).getUser().equals(receiver)){
                UserList.get(i).getMessageList().add(text);
                trobat = true;
            }
        }
    }

    @Override
    public void getEmail(User user) {

    }
}
