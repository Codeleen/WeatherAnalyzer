package climatechange;


public interface ITemperature extends Comparable<ITemperature>{

	
	public String getCountry();
	public String  getCountry3LetterCode();
	 public String getMonth();
	 public int getYear();
	 public double getTemperature(boolean getFahrenheit);  
	 
}
