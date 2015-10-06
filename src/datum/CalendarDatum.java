package datum;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDatum {
	
	SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy");
	private int dag, maand, jaar;
	
	//Constructor zonder parameters
	public CalendarDatum() throws Exception
	{
		try{
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
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//Constructor met een datum object als parameter
	public CalendarDatum(Date datum) throws Exception
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
			this.dag = dag1;
			this.maand = maand1;
			this.jaar = jaar1;
		}		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//Constructor met int parameters dag maand en jaar
	public CalendarDatum(int dag,int maand,int jaar) throws Exception
	{
		try{
		if(setDatum(dag, maand, jaar))
		{
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//Constructor met een string als parameter
	public CalendarDatum(String datum1) throws Exception
	{
		try{
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
		return this.dag;		
	}
	//Get (maand) voor Test-unit
	public int getMaand()
	{
		return this.maand;		
	}
	//Get (jaar) voor Test-unit
	public int getJaar()
	{
		return this.jaar;		
	}
	
	
	//Set (dag) voor Test-Unit
	public void setDag(int verandering) throws Exception
	{
		if(setDatum(verandering,maand,jaar))
		this.dag = verandering;
	}
	//Set (maand) voor Test-Unit
	public void setMaand(int verandering) throws Exception
	{
		if(setDatum(dag,verandering,jaar))
		this.maand = verandering;
	}
	//Set (jaar) voor Test-Unit
	public void setJaar(int verandering) throws Exception
	{
		if(setDatum(dag,maand,verandering))
		this.jaar = verandering;
	}
	
	
	//Methode voor datum in amerikaans formaat terug te geven
	public String getDatumInAmerikaansFormaat() throws Exception
	{
		String IntToStr = null; 
		try{		
		if(this.maand <10)
		{IntToStr = "0"+this.maand+"/"+this.dag+"/"+this.jaar;}
		else
		{IntToStr = this.maand+"/"+this.dag+"/"+this.jaar;}
		
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
		if(this.maand <10)
		{IntToStr = this.dag+"/"+"0"+this.maand+"/"+this.jaar;}
		else
		{IntToStr = this.dag+"/"+this.maand+"/"+this.jaar;}		
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
		string = this.dag +" "+ maandstring +" "+ jaar;
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
		Date d2 = simpleformat.parse(getDatumInEuropeesFormaat());
		Calendar cal1 = Calendar.getInstance();
    	Calendar cal2 = Calendar.getInstance();
    	cal1.setTime(d1);
    	cal2.setTime(d2);
    	
    	if(cal1.before(cal2))
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
	//Methode kijkt of parameter hetzelfde is als datum
	public Boolean equals(Date d1) throws Exception
	{
		Boolean test = false;
		try{
			Date d2 = simpleformat.parse(getDatumInEuropeesFormaat());	
			Calendar calendar1 = Calendar.getInstance();
		    Calendar calendar2 = Calendar.getInstance();
		    calendar1.setTime(d1);
		    calendar2.setTime(d2);	
		if(calendar1.equals(calendar2))
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
	//Methode vergelijkt parameter en datum
	public int compareTo(Date d1) throws Exception
	{
		int result = 0;
		try{
		Date d2 = simpleformat.parse(getDatumInEuropeesFormaat());	
		Calendar calendar1 = Calendar.getInstance();
	    Calendar calendar2 = Calendar.getInstance();
	    calendar1.setTime(d1);
	    calendar2.setTime(d2);
		String s1 = getDatumInEuropeesFormaat();
		String s2 = null;
		if(this.maand <10)
		{s2 = this.dag+"/"+"0"+this.maand+"/"+this.jaar;}
		else
		{s2 = this.dag+"/"+this.maand+"/"+this.jaar;}				
		result = s1.compareTo(s2);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
		
	}
	
	//Methode bepaalt het verschil in dagen tusssen parameter en huidige datum
	public int verschilInDagen(Date d1) throws Exception
	{
		int dagen = 0;
		try{
		Date d2 = simpleformat.parse(getDatumInEuropeesFormaat());		
		Calendar calendar1 = Calendar.getInstance();
    	Calendar calendar2 = Calendar.getInstance();
    	calendar1.setTime(d1);
    	calendar2.setTime(d2);
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
		Date d2 = simpleformat.parse(getDatumInEuropeesFormaat());		
		Calendar calendar1 = Calendar.getInstance();
    	Calendar calendar2 = Calendar.getInstance();
    	calendar1.setTime(d1);
    	calendar2.setTime(d2);
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
		Date d2 = simpleformat.parse(getDatumInEuropeesFormaat());		
		Calendar calendar1 = Calendar.getInstance();
    	Calendar calendar2 = Calendar.getInstance();
    	calendar1.setTime(d1);
    	calendar2.setTime(d2);
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
		Calendar cal = Calendar.getInstance();    
		cal.set(Calendar.DAY_OF_MONTH, this.dag);
		cal.set(Calendar.MONTH, (this.maand-1));
		cal.set(Calendar.YEAR, this.jaar);
		cal.add(Calendar.DAY_OF_MONTH, verandering);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	//Mehode verhoogt of verlaagt een nieuw datum met een aantal dagen
	public CalendarDatum veranderDatum2(int verandering) throws Exception
	{
		CalendarDatum dat = null;
		try{
		Calendar cal = Calendar.getInstance();    
		cal.set(Calendar.DAY_OF_MONTH, this.dag);
		cal.set(Calendar.MONTH, (this.maand-1));
		cal.set(Calendar.YEAR, this.jaar);
		cal.add(Calendar.DAY_OF_MONTH, verandering);
		dat = new CalendarDatum(cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH),cal.get(Calendar.YEAR));		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return dat;
	}
	
	
}