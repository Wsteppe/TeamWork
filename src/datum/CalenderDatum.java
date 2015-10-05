package datum;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CalenderDatum {

public static void main(String[] args) throws Exception
	
	{
		CalenderDatum dat = null;
		Scanner scanner = new Scanner(System.in);
		String menukeuze = null;
		String menukeuze2 = null;
		
		CalenderDatum.EersteMenu();
		menukeuze = scanner.nextLine();

		switch(menukeuze)
		{
		case "1": 
			dat = new CalenderDatum();
			System.out.println("Gekozen datum: "+dat.getDatumInEuropeesFormaat());
			break;
			
		case "2": 
			System.out.println("Kies een datum (DD/MM/YYYY): ");
		  	String case2datum = scanner.nextLine();
		  	SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
			Date case2datum2 = (Date) simpleformat.parse(case2datum);
		  	dat = new CalenderDatum(case2datum2);
			break;
			
		case "3":
			int een,twee,drie;
			System.out.println("Kies 3 integers: ");
			een = scanner.nextInt();
			twee = scanner.nextInt();
			drie = scanner.nextInt();
			dat = new CalenderDatum(een,twee,drie);
			break;
			
		case "4": 
			System.out.println("Kies een datum (DD/MM/YYYY): ");
		  	String menudatum2 = scanner.nextLine();
		  	dat = new CalenderDatum(menudatum2);
			break;
		
		case "5":
			break;
		default: 
			break;
		}
		if(menukeuze!="5")
		{			
			CalenderDatum.TweedeMenu();
			menukeuze2 = scanner.nextLine();
			switch(menukeuze2)
			{
			case "1": dat.KleinerDan();
				break;
			case "2": System.out.println("Verschil in dagen: "+dat.VerschilInDagen());
				break;
			case "3": System.out.println("Verschil in maanden: "+dat.VerschilInMaanden());
				break;
			case "4": System.out.println("Verschil in jaren: "+dat.VerschilInJaren());
				break;
			case "5": System.out.print("Kies een nieuw dag aantal: ");
					  int verandering = scanner.nextInt();
					  dat.VeranderDatum(verandering);
				break;
			case "6": System.out.print("Kies een nieuw dag aantal: ");
					  int verandering2 = scanner.nextInt();
					  System.out.println("Verwerkte datum : "+dat.VeranderDatumNO(verandering2).getDatumInEuropeesFormaat());
				break;
			case "7": System.out.println("Verwerkte datum : "+dat.getDatumInAmerikaansFormaat());
				break;
			case "8": System.out.println("Verwerkte datum : "+dat.getDatumInEuropeesFormaat());
				break;
			case "9": System.out.println("Verwerkte datum : "+dat.NaarString());
				break;
			case "10":
				break;
			default: 
				break;
			}
			System.out.println("\n\n\nDruk op een toets");
			scanner.nextLine();
		}			
		scanner.close();
	}
	
	SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
	private int dag;
	private int maand;
	private int jaar;
	
	public CalenderDatum() throws Exception
	{
		Date datum1 = new Date();
		String converteddate = simpleformat.format(datum1);
		String[] parts = converteddate.split("/");
		int dag1 = Integer.parseInt(parts[0]);
		int maand1 = Integer.parseInt(parts[1]);
		int jaar1 = Integer.parseInt(parts[2]);
		if(setDatum(dag1,maand1,jaar1))
		{
			this.dag = dag1;
			this.maand = maand1;
			this.jaar = jaar1;
		}		
	}
	public CalenderDatum(Date datum) throws Exception
	{
		Date datum2 = datum;
		String converteddate = simpleformat.format(datum2);
		String[] parts = converteddate.split("/");
		int dag1 = Integer.parseInt(parts[0]);
		int maand1 = Integer.parseInt(parts[1]);
		int jaar1 = Integer.parseInt(parts[2]);
		if(setDatum(dag1,maand1,jaar1))
		{
			this.dag = dag1;
			this.maand = maand1;
			this.jaar = jaar1;
		}		
	}
	public CalenderDatum(int dag,int maand,int jaar) throws Exception
	{
		if(setDatum(dag, maand, jaar))
		{
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}		
	}
	public CalenderDatum(String datum1) throws Exception
	{
		String stringdatum = datum1;
		String[] parts = stringdatum.split("/");
		int dag1 = Integer.parseInt(parts[0]);
		int maand1 = Integer.parseInt(parts[1]);
		int jaar1 = Integer.parseInt(parts[2]);
		if(setDatum(dag1,maand1,jaar1))
		{
			this.dag = dag1;
			this.maand = maand1;
			this.jaar = jaar1;
		}		
	}
	
	public Boolean setDatum(int dag,int maand,int jaar) throws Exception
	{
		Boolean dagtest = (dag >= 1) && (dag <= DagenInMaand(maand,jaar));
		Boolean maandtest = (maand >= 1)&&(maand <= 12);
		Boolean jaartest = (jaar >= 1700)&&(jaar <= 3000);
		if(dagtest&&maandtest&&jaartest)
		{return true;}
		else
		{return false;}
	}
	private static int DagenInMaand(int maand, int jaar) throws Exception
	{
	    int dagen_maand = 0;
	    switch (maand) {
	        case 1: dagen_maand = 31;
	        break;
	        case 2: 
	            if (((jaar % 4 == 0) && (jaar % 100 != 0)) || (jaar % 400 == 0)) 
	            {dagen_maand = 29;} 
	            else 
	            {dagen_maand = 28;}
	            break;
	        case 3: dagen_maand = 31;
	        	break;
	        case 4: dagen_maand = 30;
	        	break;
	        case 5: dagen_maand = 31;
	        	break;
	        case 6: dagen_maand = 30;
	        	break;
	        case 7: dagen_maand = 31;
	        	break;
	        case 8: dagen_maand = 31;
	        	break;
	        case 9: dagen_maand = 30;
	        	break;
	        case 10: dagen_maand = 31;
	        	break;
	        case 11: dagen_maand = 30;
	        	break;
	        case 12: dagen_maand = 31;
	            break;
	    }
	    return dagen_maand;
	}
	
	public static void EersteMenu() throws Exception
	{
		System.out.println("Eerste Menu:\n\n1: Datum wordt zelf gegenereerd\n2: Datum in een datum object\n3: Datum in 3 integers\n4: Datum als String\n5: Stop");		
	}
	public static void TweedeMenu() throws Exception

	{
		System.out.println("Tweede Menu:\n\n1: Kleiner dan huidige datum\n2: Verschil in dagen\n3: Verschil in maanden\n4: Verschil in jaren\n5: Verander dag aantal\n6: Verander dag aantal met nieuw object\n7: Amerikaans Formaat\n8: Europees Formaat\n9: ToString\n10: Terug");		
	}
	
	
	public String getDatumInAmerikaansFormaat() throws Exception
	{
		String IntToStr; 
		if(this.maand <10)
		{IntToStr = "0"+Integer.toString(this.maand)+"/"+Integer.toString(this.dag)+"/"+Integer.toString(this.jaar);}
		else
		{IntToStr = Integer.toString(this.maand)+"/"+Integer.toString(this.dag)+"/"+Integer.toString(this.jaar);}
		return IntToStr;
	} 
	public String getDatumInEuropeesFormaat() throws Exception
	{
		String IntToStr;
		if(this.maand <10)
		{IntToStr = Integer.toString(this.dag)+"/"+"0"+Integer.toString(this.maand)+"/"+Integer.toString(this.jaar);}
		else
		{IntToStr = Integer.toString(this.dag)+"/"+Integer.toString(this.maand)+"/"+Integer.toString(this.jaar);}
		return IntToStr;
	}

	
	public Boolean KleinerDan() throws Exception
	{
		String datum = simpleformat.format(new Date());
		Date d1 = simpleformat.parse(getDatumInEuropeesFormaat());
		Date d2 = simpleformat.parse(datum);
		
		Calendar cal1 = Calendar.getInstance();
    	Calendar cal2 = Calendar.getInstance();
    	cal1.setTime(d1);
    	cal2.setTime(d2);
    	
    	if(cal1.before(cal2))
    	{return true;}
    	
    	else
    	{return false;}
	}
	public int VerschilInDagen() throws Exception
	{
		String datum = simpleformat.format(new Date());
		Date d1 = simpleformat.parse(getDatumInEuropeesFormaat());
		Date d2 = simpleformat.parse(datum);
		
		Calendar calendar1 = Calendar.getInstance();
    	Calendar calendar2 = Calendar.getInstance();
    	calendar1.setTime(d1);
    	calendar2.setTime(d2);
    	if(calendar1.before(calendar2))
    	{
    		int dagen = 0;  
    		while (calendar1.before(calendar2)) 
    		{  
    			calendar1.add(Calendar.DAY_OF_MONTH, 1);  
    			dagen++;  
    		}  
    		return dagen;  
    	}
    	
    	else
    	{
    		int dagen = 0;  
    		while (calendar2.before(calendar1)) 
    		{  
    			calendar2.add(Calendar.DAY_OF_MONTH, 1);  
    			dagen++;  
    		}  
    		return dagen; 
    	}
	}   
	public int VerschilInMaanden() throws Exception
	{
		String datum = simpleformat.format(new Date());
		Date d1 = simpleformat.parse(getDatumInEuropeesFormaat());
		Date d2 = simpleformat.parse(datum);
		
		Calendar calendar1 = Calendar.getInstance();
    	Calendar calendar2 = Calendar.getInstance();
    	calendar1.setTime(d1);
    	calendar2.setTime(d2);
    	if(calendar1.before(calendar2))
    	{
    		int maanden = 0;  
    		while (calendar1.before(calendar2)) 
    		{  
    			calendar1.add(Calendar.MONTH, 1);  
    			maanden++;  
    		}  
    		return maanden;  
    	}
    	
    	else
    	{
    		int maanden = 0;  
    		while (calendar2.before(calendar1)) 
    		{  
    			calendar2.add(Calendar.MONTH, 1);  
    			maanden++;  
    		}  
    		return maanden; 
    	}
	}
	public int VerschilInJaren() throws Exception
	{
		String datum = simpleformat.format(new Date());
		Date d1 = simpleformat.parse(getDatumInEuropeesFormaat());
		Date d2 = simpleformat.parse(datum);
		
		Calendar calendar1 = Calendar.getInstance();
    	Calendar calendar2 = Calendar.getInstance();
    	calendar1.setTime(d1);
    	calendar2.setTime(d2);
    	if(calendar1.before(calendar2))
    	{
    		int jaren = 0;  
    		while (calendar1.before(calendar2)) 
    		{  
    			calendar1.add(Calendar.YEAR, 1);  
    			jaren++;  
    		}  
    		return jaren;  
    	}
    	
    	else
    	{
    		int jaren = 0;  
    		while (calendar2.before(calendar1)) 
    		{  
    			calendar2.add(Calendar.YEAR, 1);  
    			jaren++;  
    		}  
    		return jaren; 
    	} 
	}
	public void VeranderDatum(int verandering) throws Exception
	{
		if(setDatum(verandering,this.maand,this.jaar))
		{
			this.dag = verandering;
			System.out.println("Verwerkte datum : "+getDatumInEuropeesFormaat());
		}
		else
		{
			System.out.println("Er is een fout opgetreden");
		}
	}
	public CalenderDatum VeranderDatumNO(int verandering) throws Exception
	{
		if(setDatum(verandering,this.maand,this.jaar))
		{
			CalenderDatum dat = new CalenderDatum(verandering,maand,jaar);
			return (dat);
		}
		else
		{
			System.out.println("Er is een fout opgetreden");
			return null;
		}	
	}
	public String NaarString() throws Exception
	{
		String maandstring = null;
		switch(this.maand)
		{
		case 1: maandstring = "januari";
			break;
		case 2: maandstring = "februari";
			break;
		case 3: maandstring = "maart";
			break;
		case 4: maandstring = "april";
			break;
		case 5: maandstring = "mei";
			break;
		case 6: maandstring = "juni";
			break;
		case 7: maandstring = "juli";
			break;
		case 8: maandstring = "augustus";
			break;
		case 9: maandstring = "september";
			break;
		case 10: maandstring = "oktober";
			break;
		case 11: maandstring = "november";
			break;
		case 12: maandstring = "december";
			break;
			
		}
		return this.dag +" "+ maandstring +" "+ jaar;
		
	}	
}//////