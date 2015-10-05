package datum;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class GregorianDatum 
{
public static void main(String[] args) throws Exception
	
	{
		GregorianDatum dat = null;
		Scanner scanner = new Scanner(System.in);
		String menukeuze = null;
		String menukeuze2 = null;
		
		CalenderDatum.EersteMenu();
		menukeuze = scanner.nextLine();

		switch(menukeuze)
		{
		case "1": 
			dat = new GregorianDatum();
			System.out.println("Gekozen datum: "+dat.getDatumInEuropeesFormaat());
			break;
			
		case "2": 
			System.out.println("Kies een datum (DD/MM/YYYY): ");
		  	String case2datum = scanner.nextLine();
		  	SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
			Date case2datum2 = (Date) simpleformat.parse(case2datum);
		  	dat = new GregorianDatum(case2datum2);
			break;
			
		case "3":
			int een,twee,drie;
			System.out.println("Kies 3 integers: ");
			een = scanner.nextInt();
			twee = scanner.nextInt();
			drie = scanner.nextInt();
			dat = new GregorianDatum(een,twee,drie);
			break;
			
		case "4": 
			System.out.println("Kies een datum (DD/MM/YYYY): ");
		  	String menudatum2 = scanner.nextLine();
		  	dat = new GregorianDatum(menudatum2);
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
	Calendar cal = new GregorianCalendar();

	public GregorianDatum() throws Exception
{
	Date datum1 = new Date();
	String converteddate = simpleformat.format(datum1);
	String[] parts = converteddate.split("/");
	int dag1 = Integer.parseInt(parts[0]);
	int maand1 = Integer.parseInt(parts[1]);
	int jaar1 = Integer.parseInt(parts[2]);
	if(setDatum(dag1,maand1,jaar1))
	{
		cal.set(Calendar.YEAR, jaar1);
		cal.set(Calendar.MONTH, maand1-1);
		cal.set(Calendar.DAY_OF_MONTH,dag1);
	}		
}
	public GregorianDatum(Date datum) throws Exception
{
	Date datum2 = datum;
	String converteddate = simpleformat.format(datum2);
	String[] parts = converteddate.split("/");
	int dag1 = Integer.parseInt(parts[0]);
	int maand1 = Integer.parseInt(parts[1]);
	int jaar1 = Integer.parseInt(parts[2]);
	if(setDatum(dag1,maand1,jaar1))
	{
		cal.set(Calendar.YEAR, jaar1);
		cal.set(Calendar.MONTH, maand1-1);
		cal.set(Calendar.DAY_OF_MONTH,dag1);
	}		
}
	public GregorianDatum(int dag,int maand,int jaar) throws Exception
{
	if(setDatum(dag, maand, jaar))
	{
		cal.set(Calendar.YEAR, jaar);
		cal.set(Calendar.MONTH, maand-1);
		cal.set(Calendar.DAY_OF_MONTH,dag);
	}		
}
	public GregorianDatum(String datum1) throws Exception
{
	String stringdatum = datum1;
	String[] parts = stringdatum.split("/");
	int dag1 = Integer.parseInt(parts[0]);
	int maand1 = Integer.parseInt(parts[1]);
	int jaar1 = Integer.parseInt(parts[2]);
	if(setDatum(dag1,maand1,jaar1))
	{
		cal.set(Calendar.YEAR, jaar1);
		cal.set(Calendar.MONTH, maand1-1);
		cal.set(Calendar.DAY_OF_MONTH,dag1);
	}		
}
	
	private Boolean setDatum(int dag,int maand,int jaar) throws Exception
{
	Boolean dagtest = (dag >= 1) && (dag <= DagenInMaand(maand,jaar));
	Boolean maandtest = (maand >= 1)&&(maand <= 12);
	Boolean jaartest = (jaar >= 1700)&&(jaar <= 3000);
	if(dagtest&&maandtest&&jaartest)
	{return true;}
	else
	{return false;}
}
	private int DagenInMaand(int maand, int jaar) throws Exception
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
		if(cal.get(Calendar.MONTH)<9)
		{IntToStr = "0"+Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.DAY_OF_MONTH))+"/"+Integer.toString(cal.get(Calendar.YEAR));}
		else
		{IntToStr = Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.DAY_OF_MONTH))+"/"+Integer.toString(cal.YEAR);}
		return IntToStr;
	} 
	public String getDatumInEuropeesFormaat() throws Exception
	{
		String IntToStr;
		if(cal.get(Calendar.MONTH)<9)
		{IntToStr = Integer.toString(cal.get(Calendar.DAY_OF_MONTH))+"/"+"0"+Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.YEAR));}
		else
		{IntToStr = Integer.toString(cal.get(Calendar.DAY_OF_MONTH))+"/"+Integer.toString(cal.get(Calendar.MONTH)+1)+"/"+Integer.toString(cal.get(Calendar.YEAR));}
		return IntToStr;
	}
	
	public Boolean KleinerDan() throws Exception
	{
		Calendar calendar2 = new GregorianCalendar();
    	if(cal.before(calendar2))
    	{
    		return true;
    	}
    	
    	else
    	{
    		return false;
    	}
    	
	}
	public int VerschilInDagen() throws Exception
	{
		Calendar calendar1 = cal;
		Calendar calendar2 = new GregorianCalendar();
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
		Calendar calendar1 = cal;
		Calendar calendar2 = new GregorianCalendar();
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
		Calendar calendar1 = cal;
		Calendar calendar2 = new GregorianCalendar();
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
		if(setDatum(verandering,cal.get(Calendar.MONTH)+1,cal.get(Calendar.YEAR)))
		{
			cal.set(Calendar.DAY_OF_MONTH,verandering);
			System.out.println("Verwerkte datum : "+getDatumInEuropeesFormaat());
		}
		else
		{
			System.out.println("Er is een fout opgetreden");
		}
	}
	public GregorianDatum VeranderDatumNO(int verandering) throws Exception
	{
		if(setDatum(verandering,cal.get(Calendar.MONTH)+1,cal.get(Calendar.YEAR)))
		{
			GregorianDatum dat = new GregorianDatum(verandering,cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH));
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
		switch(cal.get(Calendar.MONTH)+1)
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
		return cal.get(Calendar.DAY_OF_MONTH) +" "+ maandstring +" "+ cal.get(Calendar.YEAR);
		
	}
}
