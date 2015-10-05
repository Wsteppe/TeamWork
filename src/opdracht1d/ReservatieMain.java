package opdracht1d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ReservatieMain extends JFrame{

	public ReservatieMain(){
		super("Reservatie vakantiehuisjes");
		}
	
	public static void main(String[] args) {
		//Application logic
		
		//maak array met 107 vakantiehuisjes
		int[] vakantieComplex = new int[107];
		for(int i = 0; i < vakantieComplex.length; i++){
			vakantieComplex[i] = i + 1;
		}
		
		createGUI();
		
	}
		
		public static void createGUI(){
			// JFRame Interface
			ReservatieMain venster = new ReservatieMain();
			venster.setSize(500,400);
			venster.setDefaultCloseOperation(venster.EXIT_ON_CLOSE);
			
			JLabel labelnr = new JLabel();
         	labelnr.setText("Gelieve het nummer in te geven van het vakantiehuisje ter reservatie:");
         	JTextField textNummer = new JTextField();
	        JLabel labelVanDatum = new JLabel();
	        labelVanDatum.setText("Begindatum van de reservatie:");   
	        JTextField startDatum = new JTextField();
	        JLabel labelAantalNachten = new JLabel();
	        labelAantalNachten.setText("Aantal nachten:");
	        JTextField aantalNachten = new JTextField();
	        JLabel labelNaam = new JLabel();
	        labelNaam.setText("Op naam van:");
	        JTextField naam = new JTextField();
	        JLabel labelVoorNaam = new JLabel();
	        labelVoorNaam.setText("Voornaam:");
	        JTextField voornaam = new JTextField();
	        JButton button = new JButton("Submit reservatie");

	 		Box box = Box.createVerticalBox();
	 		venster.add(box);
	 		box.add(labelnr);
	 		box.add(textNummer);
	 		box.add(labelVanDatum);
	 		box.add(startDatum);
	 		box.add(labelAantalNachten);
	 		box.add(aantalNachten);
	 		box.add(labelNaam);
	 		box.add(naam);
	 		box.add(labelVoorNaam);
	 		box.add(voornaam);
			box.add(button);
			venster.setVisible(true);
			
	        button.addActionListener(new ActionListener() {
	        	 
	            public void actionPerformed(ActionEvent e)
	            {
//	            	Datum vandaag = new Datum();
	            	
	            	//Validity checks
	               if(tryParseInt(textNummer.getText())){
	            	   int nummer = Integer.parseInt(textNummer.getText());
	            	   if(nummer < 1 || nummer > 107){
	            		   JOptionPane.showMessageDialog(null, "Dit nummer is geen geldig vakantiehuisje. Onze huisjes dragen nummers 1 tem. 107.");
	            		   return;
	            	   }
	               } else {
	            	   JOptionPane.showMessageDialog(null, "Gelieve een geldig nummer in te geven."); 
	            	   return;
	               }
	               
	               
//	               if(tryParseDatum(startDatum.getText())){
//	  		         Datum datum = new Datum(startDatum.getText());
//	            	   if(datum.kleinerDan(vandaag){
//	            		   JOptionPane.showMessageDialog(null, "Enkel toekomstige data zijn toegestaan.");
//	            		   return;
//	            	   }
//	               } else {
//	            	   JOptionPane.showMessageDialog(null, "Gelieve een geldige datum van het formaat DD/MM/JJJJ in te geven."); 
//	            	   return;
//	               }
	               
	               if(tryParseInt(aantalNachten.getText())){
	            	   int nummer = Integer.parseInt(textNummer.getText());
	            	   if(nummer < 1){
	            		   JOptionPane.showMessageDialog(null, "Gelieve een positief aantal nachten (minimum 1) in te geven.");
	            		   return;
	            	   }
	               } else {
	            	   JOptionPane.showMessageDialog(null, "Gelieve een geldig aantal nachten (minimum 1) in te geven."); 
	            	   return;
	               }
	               
	               if(naam.getText().equals("") || voornaam.getText().equals("")){
		         	   JOptionPane.showMessageDialog(null, "Gelieve zowel een naam als voornaam in te geven."); 
		         	   return;
	               }
	               
	               //add checks om te zien of al gereserveerd is.               
	               try {
	            	   // steek datalijnen in een array
	            	   int huisNummer = 0;
	            	   int plaatsKomma = 0;
	            	   Datum bezet = null;
	            	   ArrayList checkBezet = new ArrayList();
	                   Scanner scan = new Scanner("resource/reserveringen.txt");
	        
	                   while (scan.hasNextLine()) {                	   
	                       String datalijn = scan.nextLine();
	                       //insert huisjesnummer
	                       String [] velden = datalijn.split(",");
	                       Datum reservatieDatum = velden[1];
	                       //check of bezet op datum
	                       checkBezet.add(datalijn);
	                   }
	                   scan.close();
	                   
//	                   for(int i = 0; i < checkBezet.length; i++){
//	                	   if(checkBezet[i-1].equals)	                	   
//	                   }
	                   
	                   
	               } catch (Exception exc) {
	                   exc.printStackTrace();
	               }
	               
	               //write in tekstbestand
	               try{
	            	   String lijn = new String();
	            	   lijn = textNummer.getText() +"," + startDatum.getText() + "," + aantalNachten.getText() + ">" + naam.getText() + "," + voornaam.getText();
	            	   
		               PrintWriter printWriter = new PrintWriter (new FileWriter("resource/reserveringen.txt", true));
		               printWriter.println (lijn);
		               printWriter.close ();
		               JOptionPane.showMessageDialog(null, "Reservatie opgenomen in de databank!");
	               }
	               catch(Exception exc){
	            	   JOptionPane.showMessageDialog(null, "Wegschrijven van de data mislukt.\n" + exc.getMessage()); 
	               }

	            }
	        });      
		}
		
		static boolean tryParseInt(String value) {  
		     try {  
		         Integer.parseInt(value);  
		         return true;  
		      } catch (NumberFormatException e) {  
		         return false;  
		      }  
		}
		
//		static boolean tryParseDatum(string value){
//		     try {  
//		         Datum datum = new Datum(value);  
//		         return true;  
//		      } catch (NumberFormatException e) {  
//		         return false;  
//		      }  
//		}
}
