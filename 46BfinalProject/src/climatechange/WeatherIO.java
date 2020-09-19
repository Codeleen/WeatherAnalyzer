package climatechange;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class WeatherIO implements IWeatherIO {

	File taskFile;
	//reads data from file and adds it to array list 
	public ArrayList<ITemperature> readDataFromFile(String fileName) {
		
		
		ArrayList<ITemperature> allData = new ArrayList<>();
				
		//try block to create file 
		try {
			
			File worldTemps = new File(fileName);
			//System.out.println(new File(".").getAbsoluteFile());
			
			FileReader fr = new FileReader(worldTemps);
			BufferedReader br = new BufferedReader(fr);

			//to skip over first line which is headers 
			br.readLine();
			String nextLine ;
			
			//while file has a next line
			while ((nextLine = br.readLine()) != null) {
				
			//CHANGE THE "," to ",      " !!!!!
				//parse line by comma 
				String[] weatherData = nextLine.split(", ");
				
				//assigns each line as a value of data
				double temp = Double.parseDouble(weatherData[0]);
				int year = Integer.parseInt(weatherData[1]);
				String month = weatherData[2];
				String country = weatherData[3];
				String countryCode = weatherData[4];
		
				//creates new temperature object
				Temperature lineOfData3 = new Temperature(temp, year, month, country, countryCode);
				//adds to array list
				allData.add(lineOfData3);
				
				
			}
			br.close();
			fr.close();
			
		}
		//catch block for exceptions
		catch (IOException o) {
			System.out.println("error reading file and putting in Arraylsit:" + o.getMessage());
		}
		//return array list 
		return allData;
	}
	
	

	//writes subject and the temperture data headers at the to of the file
	public void writeSubjectHeaderInFile(String filename, String subject) {
		taskFile = new File(filename);
		try {
			FileWriter fw = new FileWriter(filename, true);
			fw.write(subject + "\n");
			fw.write("Temperature, Year, Month, Country, Country_Code" +"\n");
			
			
			fw.close();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		

	}

	//creates a file and writes the data in the passed in arraylist to that fie
	//calls wroteSubject header to write header  before the data
	public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) {
		filename = "task"+filename+"_climate_info.csv";
		taskFile = new File(filename);
		WeatherIO weather = new WeatherIO();
		
		weather.writeSubjectHeaderInFile(filename, topic);
		
		try {
			FileWriter fw = new FileWriter(taskFile, true);	
			
			for (ITemperature data: theWeatherList) {
				
				//reformats the temperature object into string line
				String celc = String.format("%.2f", (data.getTemperature(false)));
				String faren = String.format("%.2f", (data.getTemperature(true)));
				String temp =  celc +"(C) " + faren + "(F), " ;
				String year = Integer.toString(data.getYear())+", ";
				String month = data.getMonth()+", ";
				String country = data.getCountry()+", ";
				String countryCode = data.getCountry3LetterCode() +"\n";
				//writes to file 
				fw.write(temp+year+month+country+countryCode);
				
			
			}
		
			fw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
