package TASCA2_TAP;

import TASCA0_TAP.*;

import javax.crypto.Cipher;
import java.io.*;
import java.util.ArrayList;
import java.util.Base64;

public class StoreFileCiphers extends StoreFile {

    private String key ;
    java.security.Key aesKey;
    Cipher cipher;
    StoreFile store;

    public StoreFileCiphers( StoreFile store) throws Exception{
        super("");
        this.store = store;
        this.key =  "IWantToPassTAP12"; // 128 bit key
        this.aesKey = new javax.crypto.spec.SecretKeySpec(key.getBytes(), "AES");
        this.cipher = Cipher.getInstance("AES");
    }


    public void sendEmail(Message text) {
        byte[] encrypted = new byte[0];

        try {
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            encrypted = cipher.doFinal(text.getText().getBytes());
            text.setText(Base64.getEncoder().encodeToString(encrypted));
            store.sendEmail(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Message> getEmail(User user) {
        byte[] encrypted ;
        String decrypted = null;


        ArrayList<Message> llista = store.getEmail(user);
        for (Message message : llista) {
            encrypted = Base64.getDecoder().decode(message.getText().getBytes());
            try {
                cipher.init(Cipher.DECRYPT_MODE, aesKey);
                message.setText(new String(cipher.doFinal(encrypted)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return llista;
    }

}

