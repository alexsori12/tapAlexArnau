package TASCA2_TAP;

import TASCA0_TAP.Message;
import TASCA0_TAP.StoreFile;
import TASCA0_TAP.User;


import java.util.ArrayList;


public class StoreFileReverse extends StoreFile {

    private StoreFile store;

    public StoreFileReverse(StoreFile store){
        super("");
        this.store = store;
    }


    public void sendEmail(Message text) {
        text.setText(revearseString(text.getText()));
        store.sendEmail(text);
    }


    public ArrayList<Message> getEmail(User user) {
        store.getEmail(user).forEach(Message -> Message.setText(revearseString(Message.getText())));
        return store.getEmail(user);
    }


    public static String revearseString(String str){
        String reverse= "";
        for(int i = str.length() - 1; i >= 0; i--)
        {
            reverse = reverse + str.charAt(i);
        }
        return  reverse;
    }
}
