package TASCA0_TAP;
import java.io.*;
import java.util.*;




public final class StoreFile implements MailStore {

	
    private static final String NOM_FITXER = "Missatges.txt";
  
    private static StoreFile instance = null;


    private StoreFile() {
        
    }

    public static StoreFile getInstance() {
        if (instance == null) {
            instance = new StoreFile();
        }
        return instance;
    }


	@Override
    public void sendEmail(User receiver, Message text) {

        try {

            File file = new File(NOM_FITXER);
            
             // Si el archivo no existe, se crea!
            if (!file.exists()) {
               file.createNewFile();
            }
			BufferedWriter f= new BufferedWriter(new FileWriter(file.getAbsoluteFile(),true));
		
			String missatge= text.getReceiver()+";"+text.getSender()+";"+text.getText()+";"+text.getSubject() +";"+text.getDate();
			f.write(missatge);
			f.newLine();
			
			f.close();
		
		}catch(FileNotFoundException e) {
			System.out.println("No s'ha trobat l'arxiu amb el nom Clients.txt");
		}catch(IOException e) {
			System.out.println(" Error amb el fitxer Clients al guardar");
		}
    }

    @Override
    public ArrayList<Message> getEmail(User user) { 
    	ArrayList<Message> messageList = new ArrayList<Message>(); 
		try {
			BufferedReader f = new BufferedReader(new FileReader(NOM_FITXER));
            int cont=0;
            String receiver, sender, text, subject;
			String frase = f.readLine();
			
			while(frase != null) {
				cont++;
				try {
					
                    StringTokenizer st = new StringTokenizer(frase,";");
                    receiver = st.nextToken();
                  
                    if(receiver.equals(user.getUsername())){

                        sender = st.nextToken();
                        text = st.nextToken();
                        subject = st.nextToken();
                        messageList.add(new Message(sender,receiver,text,Integer.parseInt(st.nextToken()),subject));
                        System.out.println(" lol "+sender+ " "+text+" ");
                    }

                    frase = f.readLine();

				}catch(IllegalArgumentException e) {
					System.out.println("Error al llegir el missatge [" + cont + "] del fitxer de Missatges");
				}
				
			}
			f.close();
			return messageList;
		}catch(FileNotFoundException e) {
			System.out.println("No es ha trobat l'arxiu amb el nom Missatges.txt");
		}catch(IOException e) {
			System.out.println("ERROR AL OBRIR EL FITXER");
		}
		
		return null;
	}
    
    
    

}
