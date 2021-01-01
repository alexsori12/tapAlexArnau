package TASCA0_TAP;

import java.util.*;

public class Test {
    public static void main(String[] args) {


        ArrayList<MailBox> MailBoxArr;
        ArrayList<String> UserNamesArr;

        Scanner myInput = new Scanner( System.in );
        int store;
        do {
            System.out.print(" StoreMemory (0) or StoreFile (1):");
            store = myInput.nextInt();
        }while(store < 0 || store >1);

        //1. Initialize the mail system with an in-memory mail store
        MailSystem systemM;
        if(store == 1) systemM = new MailSystem(new StoreFile("Missatges.txt"));
        else systemM = new MailSystem(StoreMemory.getInstanceM());


        // 2. Create at least 3 users, two have the same name but different username.
        systemM.addUser(new User("repstail123", "Alex", 2000));
        systemM.addUser(new User("Zackon", "Arnau", 2001));
        systemM.addUser(new User("Torija", "Adria", 1999));
        systemM.addUser(new User("Arubu", "Rubio", 1998));
        systemM.addUser(new User("Tutu", "Arubu", 1997));

        //UsersArr = systemM.getAllUsers(); //Comprovacio users creats
        //UsersArr.forEach(System.out::println);

        // 3. Then, use the mailboxes to send a few emails between them. Make some of them share the
        //same subject and make enough so that the following tests have results.
        MailBoxArr = systemM.getUserMailBox();
        MailBoxArr.get(0).sendEmail("Zackon", "Treball TAP", "Quan començem?");
        MailBoxArr.get(1).sendEmail("repstail123", "Treball TAP", "HAHAHAHAHHA");
        MailBoxArr.get(1).sendEmail("repstail123", "Treball TAP", "Quan vulguis titu");
        MailBoxArr.get(2).sendEmail("repstail123", "Subject2", "TEXT");
        MailBoxArr.get(3).sendEmail("repstail123", "Subject3", "TEXT");
        MailBoxArr.get(3).sendEmail("repstail123", "Subject2 V2", "TEXT");
        MailBoxArr.get(3).sendEmail("user3", "BornBefore2000", "TEXT");
        MailBoxArr.get(4).sendEmail("user4", "BornBefore2000", "TEXT");



        // 4. Get one of the mailboxes and update its mail.
        MailBoxArr.get(0).listMail();
        MailBoxArr.get(0).updateMail();
        //MailBoxArr.get(1).updateMail();
        (MailBoxArr.get(0).listMail()).forEach(Message ->System.out.println(Message.toString()));

       MailBoxArr.forEach(MailBox::updateMail); // Updateamos a todos para las pruebas

        //5. List the mailbox messages in the console. (Sorted by newer first.) Use the iterable capabilities
        //of the mailbox!

        System.out.println( "\n------------------------------- 5. List the mailbox messages in the console. (Sorted by newer first.)-------------------------------\n ");
        MailBoxArr.get(0).getSortedMail(new ComparatorSortedByNew()).forEach(Message -> System.out.println(Message.toString()));

        // 6. Now list the messages by sender username using the mailbox feature
        System.out.println(" \n------------------------------- 6. Now list the messages by sender username using the mailbox feature------------------------------- \n");
        MailBoxArr.get(0).filterMailBy(Message -> Message.getSender().contains("Zackon")).forEach(Message -> System.out.println(Message.toString()));

        //7. Filter the messages with the following conditions:
        System.out.println(" \n------------------------------- 7. Filter the messages with the following conditions: -------------------------------  \n");
            //- The message subject contains a certain word.
        System.out.println(" - The message subject contains a certain word. ");
        systemM.messagesbySubject("Subject2").forEach(Message -> System.out.println(Message.toString()));
            //- The message sender is a certain user.
        System.out.println(" - The message sender is a certain user. ");
        systemM.filterMessage(Message -> Message.getSender().contains("Zackon")).forEach(Message -> System.out.println(Message.toString()));

        //8. Use the mail system object to retrieve all messages and print them.
        System.out.println("\n------------------------------- 8. Todos los mensages de la MAILSYSTEM:------------------------------- \n");
        systemM.getAllMissages().forEach(Message -> System.out.println(Message.toString()));

        //9. Filter messages globally that fulfill the following conditions:
        System.out.println("\n------------------------------- 9. Filter messages globally that fulfill the following conditions: -------------------------------\n ");
            //- The message subject is a single word.
        System.out.println(" - The message subject is a single word.");
        systemM.filterMessage(Message -> Message.getSubject().equals("Subject2")).forEach(Message -> System.out.println(Message.toString()));
            //- The sender was born after year 2000.
        System.out.println(" - The sender was born after year 2000.");
        UserNamesArr = systemM.usersAfterYear(2000);
        systemM.filterMessage(Message -> UserNamesArr.contains(Message.getSender())).forEach(Message -> System.out.println(Message.toString()));

        //10. Get the count of messages in the system and print it.
        System.out.println("\n------------------------------- 10. Get the count of messages in the system and print it------------------------------- \n ");
        System.out.println(" Number of Messages: "+systemM.numberOfMissages());

        //11. Get the average number of messages received per user and print it.
        System.out.println("\n------------------------------- 11. Get the average number of messages received per user and print it------------------------------- \n");
        System.out.println(" Average Messages/User: "+systemM.averageMessageUser());

        //12. Group the messages per subject in a Map<String, List<Message>> and print it.
        System.out.println("\n------------------------------- 12. Group the messages per subject in a Map<String, List<Message>> and print it.------------------------------- \n");
        systemM.groupMessageSubject().forEach((subject, array) -> System.out.println("Subject: ("+ subject + "): " +array));


        //13. Count the words of all messages sent by users with a certain real name.
        System.out.println("\n------------------------------- 13. Count the words of all messages sent by users with a certain real name.------------------------------- \n");
        System.out.println(" Number of words certain real name : "+systemM.countWordsByUser("Alex"));

        //14. Use the name that you used on two users. Print the result.
        System.out.println("\n------------------------------- 14. Use the name that you used on two users. Print the result.------------------------------- \n");
        System.out.println(" Number of words certain real name (repeated) : "+systemM.countWordsByUser("Arnau"));

        //15. Print the messages received by users born before year 2000.
        System.out.println("\n------------------------------- 15. Print the messages received by users born before year 2000.------------------------------- \n");
        systemM.getMessagesB4Year(2000).forEach(Message -> System.out.println(Message.toString()));
        //16. Now change the mail store to the file implementation.
    }

}
