package datum;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GregorianDatum {
	
	SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = new GregorianCalendar();

	//Constructor zonder parameters
	public GregorianDatum() throws Exception
{
	cal = new GregorianCalendar();	
}
	//Constructor met een datum object als parameter
	public GregorianDatum(Date datum) throws Exception
{
	try{
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
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
	//Constructor met int parameters dag maand en jaar
	public GregorianDatum(int dag,int maand,int jaar) throws Exception
{
	try{
	if(setDatum(dag, maand, jaar))
	{
		cal.set(Calendar.YEAR, jaar);
		cal.set(Calendar.MONTH, maand-1);
		cal.set(Calendar.DAY_OF_MONTH,dag);
	}	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
	//Constructor met een string als parameter
	public GregorianDatum(String datum1) throws Exception
{
	try{
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
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
	
	
	//Methode voor geldige waarden te controleren
	private Boolean setDatum(int dag,int maand,int jaar) throws Exception
{
	Boolean test = false;
	try{
	Boolean dagtest = (dag >= 1) && (dag <= dagenInMaand(maand,jaar));
	Boolean maandtest = (maand >= 1)&&(maand <= 12);
	Boolean jaartest = (jaar >= 1700)&&(jaar <= 3000);
	if(dagtest&&maandtest&&jaartest)
	{test = true;}
	else
	{test = false;}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return test;
}
	//Methode voor schrikkeljaren te controleren
	private int dagenInMaand(int maand, int jaar) throws Exception
{
		int dagen_maand = 0;
	try{	
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
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return dagen_maand;
}

	
	//Get (dag) voor Test-unit
	public int getDag()
	{
		return cal.get(Calendar.DAY_OF_MONTH);		
	}
	//Get (maand) voor Test-unit
	public int getMaand()
	{
		return cal.get(Calendar.MONTH)+1;		
	}
	//Get (jaar) voor Test-unit
	public int getJaar()
	{
		return cal.get(Calendar.YEAR);		
	}
	
	
	//Set (dag) voor Test-Unit
	public void setDag(int verandering) throws Exception
	{
		if(setDatum(verandering,(cal.get(Calendar.MONTH)+1),cal.get(Calendar.YEAR)))
			cal.set(Calendar.DAY_OF_MONTH,verandering);
	}
	//Set (maand) voor Test-Unit
	public void setMaand(int verandering) throws Exception
	{
		if(setDatum(cal.get(Calendar.DAY_OF_MONTH),verandering,cal.get(Calendar.YEAR)))
			cal.set(Calendar.MONTH,verandering);
	}
	//Set (jaar) voor Test-Unit
	public void setJaar(int verandering) throws Exception
	{
		if(setDatum(cal.get(Calendar.DAY_OF_MONTH),(cal.get(Calendar.MONTH)+1),verandering))
			cal.set(Calendar.YEAR,verandering);
	}
	
	
	//Methode voor datum in amerikaans formaat terug te geven
	public String getDatumInAmerikaansFormaat() throws Exception
	{
		String IntToStr = null;
		try{
		if(cal.get(Calendar.MONTH)<9)
		{IntToStr = "0"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.YEAR);}
		else
		{IntToStr = (cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DAY_OF_MONTH)+"/"+cal.get(Calendar.YEAR);}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return IntToStr;
	} 
	//Methode voor datum in europees formaat terug te geven
	public String getDatumInEuropeesFormaat() throws Exception
	{
		String IntToStr = null;
		try{		
		if(cal.get(Calendar.MONTH)<9)
		{IntToStr = cal.get(Calendar.DAY_OF_MONTH)+"/"+"0"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);}
		else
		{IntToStr = cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);}
		return IntToStr;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return IntToStr;
	}
	//Methode voor datum met uitgeschreven maand terug te geven
	public String toString()
	{
		String string = null;
		try{
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
		string = cal.get(Calendar.DAY_OF_MONTH) +" "+ maandstring +" "+ cal.get(Calendar.YEAR);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return string;
	}
	
	
	//Methode bepaalt of datum kleiner is dan huidige datum
	public Boolean kleinerDan(Date d1) throws Exception
	{
		Boolean test = false;
		try{
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(d1);
		Calendar calendar2 = new GregorianCalendar();
    	if(cal.before(calendar2))
    	{
    		test = true;
    	}
    	
    	else
    	{
    		test = false;
    	}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
    	return test;
	}
	
	
	//Methode bepaalt het verschil in dagen tusssen parameter en huidige datum
	public int verschilInDagen(Date d1) throws Exception
	{
		int dagen = 0; 
		try{
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(d1);
		Calendar calendar2 = new GregorianCalendar();
    	if(calendar1.before(calendar2))
    	{
    		dagen = 0;  
    		while (calendar1.before(calendar2)) 
    		{  
    			calendar1.add(Calendar.DAY_OF_MONTH, 1);  
    			dagen++;  
    		}  
    	}
    	
    	else
    	{
    		dagen = 0;  
    		while (calendar2.before(calendar1)) 
    		{  
    			calendar2.add(Calendar.DAY_OF_MONTH, 1);  
    			dagen++;  
    		}      		
    	}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return dagen; 
	}   
	//Methode bepaalt het verschil in maanden tusssen parameter en huidige datum
	public int verschilInMaanden(Date d1) throws Exception
	{
		int maanden = 0;  
		try{
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(d1);
		Calendar calendar2 = new GregorianCalendar();
    	if(calendar1.before(calendar2))
    	{
    		maanden = 0;  
    		while (calendar1.before(calendar2)) 
    		{  
    			calendar1.add(Calendar.MONTH, 1);  
    			maanden++;  
    		}   
    	}
    	
    	else
    	{
    		maanden = 0;  
    		while (calendar2.before(calendar1)) 
    		{  
    			calendar2.add(Calendar.MONTH, 1);  
    			maanden++;  
    		}  
    	}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return maanden; 
	}
	//Methode bepaalt het verschil in jaren tusssen parameter en huidige datum
	public int verschilInJaren(Date d1) throws Exception
	{
		int jaren = 0;  
		try{
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(d1);
		Calendar calendar2 = new GregorianCalendar();
    	if(calendar1.before(calendar2))
    	{
    		jaren = 0;  
    		while (calendar1.before(calendar2)) 
    		{  
    			calendar1.add(Calendar.YEAR, 1);  
    			jaren++;  
    		}   
    	}
    	
    	else
    	{
    		jaren = 0;  
    		while (calendar2.before(calendar1)) 
    		{  
    			calendar2.add(Calendar.YEAR, 1);  
    			jaren++;  
    		}  
    	} 
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return jaren; 
	}
	
	
	//Methode verhoogt of verlaagt datum met een aantal dagen
	public void veranderDatum(int verandering) throws Exception
	{   
		try{
		cal.add(Calendar.DAY_OF_MONTH, verandering);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//Mehode verhoogt of verlaagt een nieuw datum met een aantal dagen
	public GregorianDatum veranderDatum2(int verandering) throws Exception
	{
		GregorianDatum dat = null;
		try{
		cal.add(Calendar.DAY_OF_MONTH, verandering);
		dat = new GregorianDatum(cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH),cal.get(Calendar.YEAR));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return dat;
	}
	
	
}