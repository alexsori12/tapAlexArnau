package TASCA0_TAP;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        ArrayList<User> UsersArr;
        ArrayList<MailBox> MailBoxArr;
        ArrayList<Message> MessageArr;

        //1. Initialize the mail system with an in-memory mail store
        MailSystem systemM = new MailSystem(StoreMemory.getInstanceM());

        // 2. Create at least 3 users, two have the same name but different username.
        systemM.addUser(new User("repstail123", "alex", 2000));
        systemM.addUser(new User("Zackon", "Arnau", 2000));
        systemM.addUser(new User("user3", "user", 1999));
        systemM.addUser(new User("user4", "user", 1998));
        systemM.addUser(new User("user5", "user", 1997));

        //UsersArr = systemM.getAllUsers(); //Comprovacio users creats
        //UsersArr.forEach(System.out::println);

        // 3. Then, use the mailboxes to send a few emails between them. Make some of them share the
        //same subject and make enough so that the following tests have results.
        MailBoxArr = systemM.getUserMailBox();
        MailBoxArr.get(0).sendEmail("Zackon", "Treball TAP", "Quan començem?");
        MailBoxArr.get(1).sendEmail("repstail123", "Treball TAP", "HAHAHAHAHHA");
        MailBoxArr.get(2).sendEmail("repstail123", "Subject2", "TEXT");
        MailBoxArr.get(3).sendEmail("repstail123", "Subject3", "TEXT");
        MailBoxArr.get(3).sendEmail("repstail123", "Subject2", "TEXT");
        MailBoxArr.get(4).sendEmail("repstail123", "Subject4", "TEXT");

        // 4. Get one of the mailboxes and update its mail.
        MailBoxArr.get(0).listMail();
        MailBoxArr.get(0).updateMail();
        (MailBoxArr.get(0).listMail()).forEach(Message ->System.out.println(Message.toString()));

        //5. List the mailbox messages in the console. (Sorted by newer first.) Use the iterable capabilities
        //of the mailbox!

        // 6. Now list the messages by sender username using the mailbox feature

        //7. Filter the messages with the following conditions:
            //- The message subject contains a certain word.
            //- The message sender is a certain user.
        //8. Use the mail system object to retrieve all messages and print them.
        System.out.println("\n 8. Todos los mensages de la MAILSYSTEM: -----------------------------------");
        systemM.getAllMissages().forEach(Message -> System.out.println(Message.toString()));
        //9. Filter messages globally that fulfill the following conditions:
            //- The message subject is a single word.
        //systemM.g
            //- The sender was born after year 2000.
        //10. Get the count of messages in the system and print it.
        //11. Get the average number of messages received per user and print it.
        //12. Group the messages per subject in a Map<String, List<Message>> and print it.
        //13. Count the words of all messages sent by users with a certain real name.
        //14. Use the name that you used on two users. Print the result.
        //15. Print the messages received by users born before year 2000.
        //16. Now change the mail store to the file implementation.
    }

}
