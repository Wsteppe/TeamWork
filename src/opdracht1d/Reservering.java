package opdracht1d;

public class Reservering {
	private int huisNummer;
	//private Datum vanDatum;
	private int aantalNachten;
	private String naam;
	private String voornaam;

	public int getHuisNummer()
	{
	    return this.huisNummer;
	}
	public void setHuisNummer(int value)
	{
	     this.huisNummer = value;
	}

//	public Datum getVanDatum()
//	{
//	    return this.vanDatum;
//	}
//	public void setVanDatum(Datum value)
//	{
//	     this.vanDatum = value;
//	}

	public int getAantalNachten()
	{
	    return this.aantalNachten;
	}
	public void setAantalNachten(int value)
	{
	     this.aantalNachten = value;
	}
	
	public String getNaam()
	{
	    return this.naam;
	}
	public void setNaam(String value)
	{
	     this.naam = value;
	}
	
	public String getVoornaam()
	{
	    return this.voornaam;
	}
	public void setVoornaam (String value)
	{
	     this.voornaam = value;
	}
	
	

}
