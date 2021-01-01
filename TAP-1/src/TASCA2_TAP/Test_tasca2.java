package TASCA2_TAP;

import TASCA0_TAP.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Test_tasca2 {
    public static void main(String[] args) throws Exception {


        Scanner myInput = new Scanner(System.in);
        int store;
        do {
            System.out.print(" StoreMemory (0) or StoreFile (1):");
            store = myInput.nextInt();
        } while (store < 0 || store > 1);

        StoreFile store1;
        MailStore mailStore;
        if (store == 1) {
            do {
                System.out.print(" ChipherFile (0) | ReversedFile (1) | NormalFile (2):");
                store = myInput.nextInt();
            } while (store < 0 || store > 2);

            switch (store){

                case 0:
                    store1 = new StoreFile("MissatgesEncriptats.txt");
                    mailStore = new StoreFileCiphers(store1); break;
                case 1:
                    store1 = new StoreFile("MissatgesReversed.txt");
                    mailStore = new StoreFileReverse(store1);break;
                case 2:
                    mailStore = new StoreFile("MissatgesTasca2.txt");break;
                default: mailStore = null;
            }
        } else mailStore = StoreMemory.getInstanceM();



        ArrayList<MailBox2> mailBoxArr = new ArrayList<MailBox2>();
        mailBoxArr.add(new MailBox2(new User("repstail123", "Alex", 1999), mailStore));
        mailBoxArr.add(new MailBox2(new User("Zackon", "Arnau", 1998), mailStore));
        mailBoxArr.add(new MailBox2(new User("user3spam", "name1", 1998), mailStore));
        mailBoxArr.add(new MailBox2(new User("user4", "name1", 2000), mailStore));


        mailBoxArr.forEach(MailBox2 -> MailBox2.attach(new TooLongFilter()));
        mailBoxArr.forEach(MailBox2 -> MailBox2.attach(new SpamUserFilter()));

        /*Mensajes correctos*/
        mailBoxArr.get(0).sendEmail("Zackon", "Treball TAP", "Quan començem?");
        mailBoxArr.get(0).sendEmail("Zackon", "Student marks", "Student marks");
        mailBoxArr.get(1).sendEmail("repstail123", "Treball TAP", "HAHAHAHAHHA");
        mailBoxArr.get(1).sendEmail("repstail123", "Treball TAP", "Quan vulguis titu");


        // Mensajes no correctos por spam//
        mailBoxArr.get(2).sendEmail("repstail123", "spam", "TEXT");
        mailBoxArr.get(2).sendEmail("repstail123", "spam", "TEXT");
        mailBoxArr.get(2).sendEmail("repstail123", "spam", "TEXT");
        mailBoxArr.get(2).sendEmail("repstail123", "spam", "TEXT");

        // Mensajes  correctos por tooLong//
        mailBoxArr.get(3).sendEmail("Zackon", "TooLongFilter", "123456789-123456789");
        mailBoxArr.get(3).sendEmail("Zackon", "TooLongFilter", "123456789-1234567891");
        // Mensajes no correctos por tooLong//
        mailBoxArr.get(3).sendEmail("Zackon", "TooLongFilter", "123456789-12345678910");
        mailBoxArr.get(3).sendEmail("Zackon", "TooLongFilter", "A B C D E F G H I J K L M N Ñ O P Q R S T U V W X Y Z ");

        System.out.println("\n----------------------------SIN UPDATEAR MAILBOX:");
        mailBoxArr.forEach(MailBox2::printMessagesList);

        mailBoxArr.forEach(MailBox::updateMail); // Updateamos a todos para las pruebas
        System.out.println("\n----------------------------MAILBOX UPDATEADAS (MENSAJES CORRECTOS):");
        mailBoxArr.forEach(MailBox2::printMessagesList);

        System.out.println("\n----------------------------SPAM DE LAS MAILBOX:");
        System.out.println("\t\t[MAILBOX]           [MESSAGE]");
        mailBoxArr.forEach(MailBox2::printSpamList);


    }
}
