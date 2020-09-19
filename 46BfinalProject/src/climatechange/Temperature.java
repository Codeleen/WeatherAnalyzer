package climatechange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temperature implements ITemperature{
	private String country; 
	private String countryCode;
	private String month;
	private int year;
	private double temperature;
	
//creates a temperature object with these values of recorded dat
	public Temperature(double theTemperature,int theYear, String theMonth,  String theCountry, String theCountryCode) {
		country = theCountry; 
		countryCode = theCountryCode;
		month = theMonth;
		year = theYear;
		temperature= theTemperature;
	}


	public String getCountry() {
		return country;
	}


	public String getCountry3LetterCode() {
		return countryCode;
	}


	public String getMonth() {
		return month;
	}


	public int getYear() {
		return year;
	}

	//gets temperature and is able to return both celciu sand farenheit value 
	public double getTemperature(boolean getFahrenheit) {
		if (getFahrenheit==false)
		{
			return temperature  ;
		}
		return ((temperature *9/5) +32);
	}

//compareto method which takes in temp object and compares by first temperture, then country, year, and month
	public int compareTo(ITemperature thatTemp) {
		
		List<String> listOfMonths = new ArrayList<String>(Arrays.asList("zero","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
		
		  if (thatTemp.getTemperature(false) == temperature) {
			  
			  return compareByCountry(thatTemp, listOfMonths);
		  }
		  else 
		  {
			return compareByTemperature(thatTemp);
		  }
	}

	private int compareByTemperature(ITemperature thatTemp) {
		if (thatTemp.getTemperature(false)>temperature) 
		{
			return -1;
		}
			return 1;
	}

	private int compareByCountry(ITemperature thatTemp, List<String> listOfMonths) {
		if (thatTemp.getCountry().equalsIgnoreCase(country))
		  {
			  return compareByYear(thatTemp, listOfMonths);
		  }
		  else 
		  {
			  if (thatTemp.getCountry().compareTo(country) > 0)
			  {
				  return -1;
			  }
				  return 1;
		  }
	}

	private int compareByYear(ITemperature thatTemp, List<String> listOfMonths) {
		if (thatTemp.getYear()==year)
		  {
			 return compareByMonth(thatTemp, listOfMonths);
		  }
		  else
		  {
			  if (thatTemp.getYear()>year)
			  {
				  return -1;
				 
			  }
			  return 1;
			  
		  }
	}

	private int compareByMonth(ITemperature thatTemp, List<String> listOfMonths) {
		if (thatTemp.getMonth().equalsIgnoreCase(month)) 
		 {
			 return 0;
		 }
		 else if (listOfMonths.indexOf(thatTemp.getMonth()) >(listOfMonths.indexOf(month)))
				 
		 {
			 return -1;
		 }
		 return 1;
	}
}
