package TASCA0_TAP;
import java.io.*;
import java.util.*;
import java.math.*;

public final class StoreFile implements MailStore {


    @Override
    public void sendEmail(User receiver, Message text) {

    }

    @Override
    public void getEmail(User user) {
		try {
			BufferedReader f = new BufferedReader(new FileReader("Missatges.txt"));
            int cont=0;
            String receiver, sender,text;
			String frase = f.readLine();
			
			while(frase != null) {
				cont++;
				try {
					
					StringTokenizer st = new StringTokenizer(frase,";");
                    receiver = st.nextToken();
                    sender = st.nextToken();
                    text = st.nextToken();
                    Missatges aux = new Missatges(sender,receiver,text,Integer.parseInt(st.nextToken()));
                    
                    frase = f.readLine();

				}catch(IllegalArgumentException e) {
					System.out.println("Error al llegir el missatge [" + cont + "] del fitxer de Missatges");
				}
				
			}
			
			f.close();
		}catch(FileNotFoundException e) {
			System.out.println("No es ha trobat l'arxiu amb el nom Missatges.txt");
		}catch(IOException e) {
			System.out.println("ERROR AL OBRIR EL FITXER");
		}
	}

}
