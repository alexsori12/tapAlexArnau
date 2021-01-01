package TASCA0_TAP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Admin {
    private static MailSystem systemM;
    static Scanner myInput;

    public static void main(String[] args) {
        boolean out = false;
        initializeMain();
        do {
            out = switchAdmin(out);
        }while(!out);
        myInput.close();
    }

    public static boolean switchAdmin(boolean out)
    {
        int menu;
        cleanWindow();
        menu = showMenuAdm();
        while(menu<0||menu>3){
            cleanWindow();
            System.out.println("Wrong option, please, try again\n");
            menu = showMenuAdm();
        }
        switch (menu) {
            case 0:
                out = true;
                break;

            case 1: {
                cleanWindow();
                String username;
                String name;
                int year;

                myInput.nextLine();
                System.out.print("Username:\t");
                username = myInput.nextLine();
                System.out.print("\nName:\t");
                name = myInput.nextLine();
                System.out.print("\nYear:\t");
                year = myInput.nextInt();
                createUser(new User(username, name, year));
                break;
            }
            case 2:

                break;

            case 3:
            {
                cleanWindow();
                MailBox mailbox;
                System.out.println("Username to log in");
                String login = myInput.nextLine();
                mailbox = systemM.getUserMailBox().stream()
                        .filter(mailBox -> mailBox.getUser().getUsername().equals(login))
                        .collect(Collectors.toList())
                        .get(0);
                do{
                    menu = switchUser(mailbox);
                }while(menu != 0);
                break;
            }
            default :
        }
        return out;
    }

    public static int switchUser(MailBox mailbox)
    {
        int menu;
        cleanWindow();
        menu = showMenuUser();
        while(menu<0||menu>5){
            cleanWindow();
            System.out.println("Wrong option, please, try again\n\n");
            menu = showMenuAdm();
        }
        switch(menu){
            case 0:break;
            case 1:
            {
                cleanWindow();
                String subject;
                String text;
                String user;
                System.out.println("Subject:");
                subject = myInput.nextLine();
                System.out.println("\nText:");
                text = myInput.nextLine();
                System.out.println("\nSend to?:");
                user = myInput.nextLine();
                if(checkingUser(user)){
                    mailbox.sendEmail(user, subject, text);
                }else{
                    System.out.println("ERROR: Not existing");
                }
                break;
            }
            case 2:
            {
                mailbox.updateMail();
                break;
            }
            case 3:
            {
                ArrayList<Message> mails = mailbox.getMessageList();
                for(Message m: mails){
                    System.out.println(m.toString());
                }
                System.out.println("\n write Continue and press enter");
                myInput.nextLine();
                break;
            }
            case 4:
            {
                
                break;
            }
            case 5:
            {
                /*System.out.print("Filter:\t");
                Predicate<Message> m = myInput.nextLine();
                ArrayList<Message> messages = mailbox.getMessageList().stream()
                .flatMap(Collection::stream)
                .filter(m)
                .collect(Collectors.toList()); 
                for(Message mi: messages){
                    System.out.println(m.toString());
                }*/
                break;
            }
            default :
        }
        return menu;
    }

    public static void initializeMain()
    {
        myInput = new Scanner(System.in);
        int store;
        do {
            System.out.print(" StoreMemory (0) or StoreFile (1):");
            store = myInput.nextInt();
        } while (store < 0 || store > 1);

        if (store==1)
            systemM = new MailSystem(StoreFile.getInstanceF());
        else
            systemM = new MailSystem(StoreMemory.getInstanceM());
    }

    public static void cleanWindow() {
        for(int i = 0; i < 40; i++)
            System.out.println();
    }
    
    public static int showMenuAdm() {
        System.out.println("----ADMIN MENU----\n");
        System.out.println("1.Add User");
        System.out.println("2.Filter messages");
        System.out.println("3.Login User");
        System.out.println("0.Exit");
        return (myInput.nextInt());
    }

    public static int showMenuUser() {
        System.out.println("----USER MENU----\n");
        System.out.println("1.Send Missage");
        System.out.println("2.Update messages");
        System.out.println("3.List of messages");
        System.out.println("4.Sort messages");
        System.out.println("5.Filter messages");
        System.out.println("0.Exit");
        return(myInput.nextInt());
    }

    public static boolean checkingUser(String username){
        List<String> usernames = systemM.getAllUsers().stream()
                                        .map(User -> User.getUsername())
                                        .collect(Collectors.toList());
        return (usernames.contains(username));
    }

    public static int createUser(User user) {
        systemM.addUser(user);
        return 0;
    }

    public void filter(){
        //To implement
    }



    
}
