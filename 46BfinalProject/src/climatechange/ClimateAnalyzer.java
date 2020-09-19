package climatechange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

//This class is used to analyze ITemeprature objects from a supplied data set and write the findings into files 
public class ClimateAnalyzer implements IClimateAnalyzer {
	
	//this is the array list which supplies the data you are analyzing
	ArrayList<ITemperature> data;
	String fileName;

	// constructor that takes filename to create the array list with the data which you are accessing
	//array list is initialized by calling write method in climate anayzer
	public ClimateAnalyzer(String theFileName) {
		fileName = theFileName;
		WeatherIO weather = new WeatherIO();
		data = weather.readDataFromFile(fileName);
	}

	// gets Lowest temperature of given month and country
	public ITemperature getLowestTempByMonth(String country, int month) {

		//string of months for integer to string reference 
		List<String> listOfMonths = new ArrayList<String>(Arrays.asList("zero", "Jan", "Feb", "Mar", "Apr", "May",
				"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
		
		//creates array list with same contents as supplied data
		ArrayList<ITemperature> lowestByMonth = data;
		ArrayList<ITemperature> newList = new ArrayList<ITemperature>();

		//for each ITemp object in a data, if the country and month match the supplied ones, add that object to the new list
		for (ITemperature t : lowestByMonth) {
			if ((t.getCountry().equals(country)) && (t.getMonth().equals(listOfMonths.get(month)))) {
								newList.add(t);

			}
		}
		//initialize a Itemp object as lowest possible value
		ITemperature lowest = new Temperature(Double.MAX_VALUE, Integer.MAX_VALUE, "", "", "");
		//goes through the newlly created arraylist and finds the lowest  
		for (ITemperature z : newList) {
			if (z.compareTo(lowest) == -1) {
				lowest = z;
			}
		}
		return lowest;

	}
	//finds highest temperature for the supplied country and month
	public ITemperature getHighestTempByMonth(String country, int month) {
		//string of months for integer to string reference 
		List<String> listOfMonths = new ArrayList<String>(Arrays.asList("zero", "Jan", "Feb", "Mar", "Apr", "May",
				"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));

		//list with supplied data
		ArrayList<ITemperature> highestByMonth = data;
		ArrayList<ITemperature> newList = new ArrayList<ITemperature>();
		//for each ITemp object in a data, if the country and month match the supplied ones, add that object to the new list
		for (ITemperature t : highestByMonth) {
			if ((t.getCountry().equals(country)) && (t.getMonth().equals(listOfMonths.get(month)))) {
				newList.add(t);
			}
		}
		//loops through to find highest
		ITemperature highest = new Temperature(Double.MIN_VALUE, Integer.MIN_VALUE, "", "", "");
		for (ITemperature z : newList) {
			if (z.compareTo(highest) == 1) {
				highest = z;
			}
		}
		return highest;

	}
		// finds lowest temperature for the supplied country and year
	public ITemperature getLowestTempByYear(String country, int year) {
		ArrayList<ITemperature> lowestByYear = data;
		ArrayList<ITemperature> newList = new ArrayList<ITemperature>();
		//for each ITemp object in a data, if the country and year match the supplied ones, add that object to the new list
		for (ITemperature t : lowestByYear) {
			if ((t.getCountry().equals(country)) && (t.getYear() == year)) {
				newList.add(t);
			}
		}
		//loops through new list to find the lowest
		ITemperature lowest = new Temperature(Double.MAX_VALUE, Integer.MAX_VALUE, "", "", "");
		for (ITemperature z : newList) {
			if (z.compareTo(lowest) == -1) {
				lowest = z;
			}
		}
		return lowest;

	}

	//method finds highest temperature for the supplied country and year
	public ITemperature getHighestTempByYear(String country, int year) {
		ArrayList<ITemperature> newList = new ArrayList<ITemperature>();
		ArrayList<ITemperature> highestByYear = data;
		//for each ITemp object in a data, if the country and month match the supplied ones, add that object to the new list
		for (ITemperature t : highestByYear) {
			if ((t.getCountry().equals(country)) && (t.getYear() == year)) {
				newList.add(t);
			}
		}
		//loops through new list to find highest
		ITemperature highest = new Temperature(Double.MIN_VALUE, Integer.MIN_VALUE, "", "", "");
		for (ITemperature z : newList) {
			if (z.compareTo(highest) == 1) {
				highest = z;
			}
		}
		return highest;

	}

	//gets all temperature objects of the given country and range values
	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp) {

		ArrayList<ITemperature> newList = new ArrayList<ITemperature>();
		ArrayList<ITemperature> inRange = data;
		//loops through data and if country matches and temp is within given range, adds to new list
		for (ITemperature t : inRange) {
			if ((t.getCountry().equals(country)) && t.getTemperature(false) < rangeHighTemp
					&& t.getTemperature(false) > rangeLowTemp) {
				newList.add(t);
			}
		}
		//list put into set 
		TreeSet<ITemperature> theSet = new TreeSet<ITemperature>(newList);

		return theSet;
	}
	
	//gets the lowest temperature for given country 
	public ITemperature getLowestTempYearByCountry(String country) {
		ArrayList<ITemperature> newList = new ArrayList<ITemperature>();
		ArrayList<ITemperature> lowestByCountry = data;
		//loops through data. if country matches, adds to new list
		for (ITemperature t : lowestByCountry) {
			if ((t.getCountry().equals(country))) {
				newList.add(t);
			}
		}
		//loops thrpugh new list to get lowest temp value
		ITemperature lowest = new Temperature(Double.MAX_VALUE, Integer.MAX_VALUE, "", "", "");
		for (ITemperature z : newList) {
			if (z.compareTo(lowest) == -1) {
				lowest = z;
			}
		}
		return lowest;
	}

	//gets highest recorded temp for given country
	public ITemperature getHighestTempYearByCountry(String country) {
		ArrayList<ITemperature> newList = new ArrayList<ITemperature>();
		ArrayList<ITemperature> highestByCountry = data;
		//loops through data list and if country is same as supplied, adds temp object to new list
		for (ITemperature t : highestByCountry) {
			if ((t.getCountry().equals(country))) {
				newList.add(t);
			}
		}
		//loops through new list to get largest value
		ITemperature highest = new Temperature(Double.MIN_VALUE, Integer.MIN_VALUE, "", "", "");
		for (ITemperature z : newList) {
			if (z.compareTo(highest) == 1) {
				highest = z;
			}
		}
		return highest;

	}

	//gets top ten lowest recorded temp objects for given month
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month) {
		//puts data into a treeset so it is sorted
		TreeSet<ITemperature> theSet = new TreeSet<ITemperature>(data);
		//initialize empty list for all countries that are already used
		ArrayList<String> usedCountries = new ArrayList<String>();

		ArrayList<ITemperature> tenLowest = new ArrayList<>();
		//string of months for integer to string reference 
		List<String> listOfMonths = new ArrayList<String>(Arrays.asList("zero", "Jan", "Feb", "Mar", "Apr", "May",
				"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));

		//loops through data set and if month matches and country hasnt been used and there arenot yet ten
		//then the object is added to new list and country is added to used countries
		for (ITemperature x : theSet) {
			if ((x.getMonth().equals(listOfMonths.get(month))) && !(usedCountries.contains(x.getCountry()))
					&& tenLowest.size() < 10) {
				tenLowest.add(x);
				usedCountries.add(x.getCountry());
			}
		}
		return tenLowest;

	}

	//gets top ten highest countries for given month
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month) {
		TreeSet<ITemperature> toReorder = new TreeSet<ITemperature>(data);
		//puts the data into a treeset in order from largest to smallest temp value
		TreeSet<ITemperature> theSet = (TreeSet<ITemperature>) toReorder.descendingSet();

		ArrayList<String> usedCountries = new ArrayList<String>();

		ArrayList<ITemperature> tenHighest = new ArrayList<>();
		//string of months for integer to string reference 
		List<String> listOfMonths = new ArrayList<String>(Arrays.asList("zero", "Jan", "Feb", "Mar", "Apr", "May",
				"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));

		//loops through data set and if month matches and country hasnt been used and there arenot yet ten
				//then the object is added to new list and country is added to used countries
		for (ITemperature x : theSet) {
			if ((x.getMonth().equals(listOfMonths.get(month))) && !(usedCountries.contains(x.getCountry()))
					&& tenHighest.size() < 10) {
				tenHighest.add(x);
				usedCountries.add(x.getCountry());
			}
		}
		//re orders list so that its is not highest to lowest
		Collections.sort(tenHighest);
		return tenHighest;

	}

	//gets top ten lowest temps overall
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp() {
		TreeSet<ITemperature> theSet = new TreeSet<ITemperature>(data);
		ArrayList<String> usedCountries = new ArrayList<String>();

		ArrayList<ITemperature> tenLowest = new ArrayList<>();
		//loops through set of data to get to ten, making sure countries arent reused by adding to list of used countries
		//adds ten to new list
		for (ITemperature x : theSet) {
			if (!(usedCountries.contains(x.getCountry())) && tenLowest.size() < 10) {
				tenLowest.add(x);
				usedCountries.add(x.getCountry());
			}
		}
		return tenLowest;
	}

	@Override
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp() {
		TreeSet<ITemperature> toReorder = new TreeSet<ITemperature>(data);
		//puts set in order from greatest to least
		TreeSet<ITemperature> theSet = (TreeSet<ITemperature>) toReorder.descendingSet();

		ArrayList<String> usedCountries = new ArrayList<String>();

		ArrayList<ITemperature> tenHighest = new ArrayList<>();
		//loops through set of data to get to ten, making sure countries arent reused by adding to list of used countries
		//adds ten to new list
		for (ITemperature x : theSet) {
			if (!(usedCountries.contains(x.getCountry())) && tenHighest.size() < 10) {
				tenHighest.add(x);
				usedCountries.add(x.getCountry());
			}
		}
		//re orders so its in lowest to highest
		Collections.sort(tenHighest);
		return tenHighest;

	}

	//get all temperatures within given range
	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp) {
		ArrayList<Integer> indexES = new ArrayList<Integer>();
		ArrayList<ITemperature> inRange = data;
		//loops through data and if data is not in range, index of the data will be added to list of ints
		for (ITemperature t : inRange) {
			if (t.getTemperature(false) > highRangeTemp || t.getTemperature(false) < lowRangeTemp) {
				indexES.add(inRange.indexOf(t));
			}
		}
		//loops through indexes and removes the temp objects from data set at given index
		int count = 0;
		for (int t : indexES) {
			inRange.remove(t - count);
			count++;
		}
		//sorts list
		TreeSet<ITemperature> toSort = new TreeSet<ITemperature>(inRange);
		ArrayList<ITemperature> sortedSetInRange = new ArrayList<ITemperature>(toSort);
		return sortedSetInRange;
	}

	//gets the top ten countries with the greatest delta of two given years of the same month
	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2) {
		//list for months string to int reference
		List<String> listOfMonths = new ArrayList<String>(Arrays.asList("zero", "Jan", "Feb", "Mar", "Apr", "May",
				"Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));

		
		TreeSet<ITemperature> theSet = new TreeSet<ITemperature>(data);
		TreeSet<ITemperature> allDeltaTemps = new TreeSet<ITemperature>();

		//loops through data set and if month and year 1 match 
		//loops through again, if month and year 2 match, compare those two temperature objects to get deltas
		for (ITemperature x : theSet) {
			if (x.getMonth().equals(listOfMonths.get(month)) && x.getYear() == year1) {

				for (ITemperature y : theSet)
					if (y.getMonth().equals(listOfMonths.get(month)) && y.getYear() == year2
							&& x.getCountry().equals(y.getCountry())) {

						//get delta of the temp and year
						double deltaTemp = Math.abs(x.getTemperature(false) - y.getTemperature(false));
						int deltaYear = Math.abs(x.getYear() - y.getYear());
						//creates new temperature object with the deltas and empty strings
						ITemperature newAddition = new Temperature(deltaTemp, deltaYear, x.getMonth(), x.getCountry(),
								x.getCountry3LetterCode());
						//adds this new object to a set
						allDeltaTemps.add(newAddition);
					}
			}
		}
		//puts in decending to get the top ten deltas
		TreeSet<ITemperature> descendingDeltas = (TreeSet<ITemperature>) allDeltaTemps.descendingSet();
		ArrayList<ITemperature> topTenDeltas = new ArrayList<ITemperature>();
		//loops through to add first ten to new set
		int count = 0;
		for (ITemperature delta : descendingDeltas) {
			topTenDeltas.add(delta);
			count++;
			if (count == 10) {
				break;
			}
		}
		//order the set of top ten by lowest to highest
		Collections.sort(topTenDeltas);
		return topTenDeltas;
	}

	
	
	//this method will call all of the above methods and write them into their own files based on collected data from user input
	//this is the primary methods that creates the scanner and calls its sub methods 
	public void runClimateAnalyzer() {
		WeatherIO weatherObject = new WeatherIO();
		Scanner in = new Scanner(System.in);
		
		writeA1File(weatherObject, in);
		writeA2File(weatherObject, in);   
		writeA3File(weatherObject, in);
		writeA4File(weatherObject, in);
		writeB1File(weatherObject, in);
		writeB2File(weatherObject, in);
		writeB3File(weatherObject, in);
		writeC1File(weatherObject, in);
		in.close();
	}

	//writes the first two methods (task1) into a file with user input
	private void writeA1File(WeatherIO weatherObject, Scanner in) {
		String fileName = "A1";
		ArrayList<ITemperature> task1ListA = new ArrayList<ITemperature>();
		ArrayList<ITemperature> taskSecondListA = new ArrayList<ITemperature>();
		
		System.out.println("You are now going to complete at task A1");
		
		System.out.println("Input a valid country: ");
		String country = in.nextLine();

		//get country
		char letter = country.charAt(0);
		Character.toUpperCase(letter);
		country = letter + country.substring(1);
		
		//make sure country valid - see helper method
		while (isCountryValid(country) == false) {
			System.out.println("Country input is Invalid, try again: ");
			country = in.nextLine();
		}

		//get month
		System.out.println("Input a valid month number: ");
		int month = in.nextInt();
		//make sure month is valid
		if (month > 12 || month < 1) {
			System.out.println("Month input is out of bounds, input a number between 1 and 12: ");
			month = in.nextInt();
		}
		in.nextLine();
		
		//adds each temperature object into a arraylist so that it can be written
		task1ListA.add(getLowestTempByMonth(country, month));
		taskSecondListA.add(getHighestTempByMonth(country, month));
		
		//ask for description
		System.out.println("Write Description about the first task data: ");
		String subjectA1 = "A1: " + in.nextLine();
		System.out.println("Write Description about next task data: ");
		String subjectA1Second = "A1: " + in.nextLine();
		
		//writes both array lists into the same file
		weatherObject.writeDataToFile(fileName, subjectA1, task1ListA);
		weatherObject.writeDataToFile(fileName, subjectA1Second, taskSecondListA);
	}
	
	//writes task a2 into a file
	private void writeA2File(WeatherIO weatherObject, Scanner in) {
		String fileName = "A2";
		
		ArrayList<ITemperature> task2ListA = new ArrayList<ITemperature>();
		ArrayList<ITemperature> task2SecondListA = new ArrayList<ITemperature>();
		
		System.out.println("You are now going to complete at task A2");
		//get country
		System.out.println("Input a valid country: ");
		String country = in.nextLine();

		//check country
		char letter = country.charAt(0);
		Character.toUpperCase(letter);
		country = letter + country.substring(1);
		
		while (isCountryValid(country) == false) {
			System.out.println("Country input is Invalid, try again: ");
			country = in.nextLine();
		}

		//get year
		System.out.println("Input a valid year: ");
		int year = in.nextInt();
		//check month
		if (year < 1999 || year > 2017) {
			System.out.println("Year input is out of bounds, input a year from 2000 and 2016: ");
			year = in.nextInt();
		}
		in.nextLine();
		
		
		task2ListA.add(getLowestTempByYear(country, year));
		task2SecondListA.add(getHighestTempByYear(country,year));
		
		System.out.println("Write Description about first task in A2 data: ");
		String subjectA2 = "A2: " + in.nextLine();
		System.out.println("Write Description about next task in A2 data: ");
		String subjectA2second = "A2: " + in.nextLine();
		
		weatherObject.writeDataToFile(fileName, subjectA2, task2ListA);
		weatherObject.writeDataToFile(fileName, subjectA2second, task2SecondListA);
	}

	//writes task a3 into file with user input 
	private void writeA3File(WeatherIO weatherObject, Scanner in) {
		String fileName = "A3";
		
		System.out.println("You are now going to complete at task A3");
		//get country
		System.out.println("Input a valid country: ");
		String country = in.nextLine();
		//check country
		char letter = country.charAt(0);
		Character.toUpperCase(letter);
		country = letter + country.substring(1);
		
		while (isCountryValid(country) == false) {
			System.out.println("Country input is Invalid, try again: ");
			country = in.nextLine();
		}

		//get range values
		System.out.println("Input low temperature Range value: ");
		Double temp1 = in.nextDouble();
		System.out.println("Input high temperature Range value: ");
		Double temp2 = in.nextDouble();
		
		in.nextLine();
		
		//turns the treeset returned by the method into an arraylist to be written
		TreeSet<ITemperature> lowSet =getTempWithinRange(country, temp1, temp2);
		ArrayList<ITemperature> task3ListA = new ArrayList<ITemperature>(lowSet);
		
		
		System.out.println("Write Description about taskA3 data: ");
		String subjectA3 = "A3: " + in.nextLine();
		
		//writes the list as file
		weatherObject.writeDataToFile(fileName, subjectA3, task3ListA);
	}
	
	private void writeA4File(WeatherIO weatherObject, Scanner in) {
		String fileName = "A4";
		
		ArrayList<ITemperature> task4ListA = new ArrayList<ITemperature>();
		ArrayList<ITemperature> task4SecondListA = new ArrayList<ITemperature>();
		
		System.out.println("You are now going to complete at task A4");
		//get country
		System.out.println("Input a valid country: ");
		String country = in.nextLine();

		//check country
		char letter = country.charAt(0);
		Character.toUpperCase(letter);
		country = letter + country.substring(1);
		
		while (isCountryValid(country) == false) {
			System.out.println("Country input is Invalid, try again: ");
			country = in.nextLine();
		}

		//adds both temperature objects to diff arraylists
		task4ListA.add(getLowestTempYearByCountry(country));
		task4SecondListA.add(getHighestTempYearByCountry(country));
		
		System.out.println("Write Description about first task in A4 data: ");
		String subjectA2 ="A4: " + in.nextLine();
		System.out.println("Write Description about next task in A4 data: ");
		String subjectA2next = "A4: " +in.nextLine();
		
		//writes both array lists into the same file
		weatherObject.writeDataToFile(fileName, subjectA2, task4ListA);
		weatherObject.writeDataToFile(fileName, subjectA2next, task4SecondListA);
	}
	
	private void writeB1File(WeatherIO weatherObject, Scanner in) {
		String fileName = "B1";
		
		System.out.println("You are now going to complete at task B1");
		//get month
		System.out.println("Input a valid month number: ");
		int month = in.nextInt();
		//checks month input validity
		if (month > 12 || month < 1) {
			System.out.println("Month input is out of bounds, input a number between 1 and 12: ");
			month = in.nextInt();
		}
		in.nextLine();
		
		//calls each method and assigns to array lists 
		ArrayList<ITemperature> task1ListB =  allCountriesGetTop10LowestTemp(month);
		ArrayList<ITemperature> task1ListBnext =  allCountriesGetTop10HighestTemp(month);
		
		//gets descriptions
		System.out.println("Write Description about first task B1 data: ");
		String subjectB1 = "B1: " +in.nextLine();
		System.out.println("Write Description about next task B1 data: ");
		String subjectB1next = "B1: " +in.nextLine();
		
		//writes both lists to the same file
		weatherObject.writeDataToFile(fileName, subjectB1, task1ListB);
		weatherObject.writeDataToFile(fileName, subjectB1next, task1ListBnext);
	}
	
	
	private void writeB2File(WeatherIO weatherObject, Scanner in) {
		String fileName = "B2";
		System.out.println("You are now going to complete at task B2");
		
		//calls methods and assigns returns to lists
		ArrayList<ITemperature> task2ListB =  allCountriesGetTop10LowestTemp();
		ArrayList<ITemperature> task2ListBnext =  allCountriesGetTop10HighestTemp();
		
		
		System.out.println("Write Description about taskB2 data: ");
		String subjectB2 = "B2: " +in.nextLine();
		System.out.println("Write Description about taskB2 data: ");
		String subjectB2next = "B2: "+in.nextLine();
		
		//writes each array list to the same file 
		weatherObject.writeDataToFile(fileName, subjectB2, task2ListB);
		weatherObject.writeDataToFile(fileName, subjectB2next, task2ListBnext);
	}
	
	private void writeB3File(WeatherIO weatherObject, Scanner in) {
		String fileName = "B3";
		
		System.out.println("You are now going to complete at task B3");
		//get range values
		System.out.println("Input low temperature Range value: ");
		Double temp1 = in.nextDouble();
		System.out.println("Input high temperature Range value: ");
		Double temp2 = in.nextDouble();		
		in.nextLine();
		
		//calls method and assigns to array list
		ArrayList<ITemperature> task3ListB  =allCountriesGetAllDataWithinTempRange(temp1, temp2);

		System.out.println("Write Description about taskB3 data: ");
		String subjectB3 =  "B3: "+ in.nextLine();
		
		//writes list into file
		weatherObject.writeDataToFile(fileName, subjectB3, task3ListB);
	}
	
	
	private void writeC1File(WeatherIO weatherObject, Scanner in) {
		String fileName = "C1";
		
		System.out.println("You are now going to complete at task C1");
		//gets month
		System.out.println("Input a valid month number: ");
		int month = in.nextInt();
		//checks month
		if (month > 12 || month < 1) {
			System.out.println("Month input is out of bounds, input a number between 1 and 12: ");
			month = in.nextInt();
		}
		
		//get year values and makes sure they're within data range 
		System.out.println("Input the first Year you want to compare: ");
		int year1 = in.nextInt();
		if (year1 < 1999 || year1 > 2017) {
			System.out.println("Year input is out of bounds, input a year from 2000 and 2016: ");
			year1 = in.nextInt();
		}
		System.out.println("Input the next year you want to compare: ");
		int year2 = in.nextInt();
		if (year2 < 1999 || year2 > 2017) {
			System.out.println("Year input is out of bounds, input a year from 2000 and 2016: "); 
			year2 = in.nextInt();
		}
		in.nextLine();
		
		//calls method with input values and assigns to list
		ArrayList<ITemperature> task1ListC =allCountriesTop10TempDelta(month, year1, year2);

		System.out.println("Write Description about taskC1 data: ");
		String subjectC1 = "C1: "+ in.nextLine();
		
		//writes list to file by calling method from WeatherIO
		weatherObject.writeDataToFile(fileName, subjectC1, task1ListC);
	} 
	
	
	//sub-sub-method to check if country input is valid 
	boolean isCountryValid(String country) {
		ArrayList<ITemperature> allData = data;
		ArrayList<String> countries = new ArrayList<String>();
		//loops through data list and adds all contents into a list, but lower case
		for (ITemperature t : allData) {
			countries.add(t.getCountry().toLowerCase());
		}
		//if the inputed country is in this new list, returns true
		if (countries.contains(country.toLowerCase()))
			
		{
			return true;
		}
		return false;

	}

}
