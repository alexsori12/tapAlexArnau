package TASCA0_TAP;

import java.util.ArrayList;


public class StoreMemory implements MailStore {
	
	private static StoreMemory instance = null;

    public ArrayList<UserList> UserList=null;

    private StoreMemory() {
        UserList = new ArrayList<UserList>();
    }

    public static StoreMemory getInstanceM() {
        if (instance == null) {
            instance = new StoreMemory();
        }
        return instance;
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
