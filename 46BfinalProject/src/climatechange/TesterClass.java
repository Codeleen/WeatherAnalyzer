package climatechange;

//import java.util.ArrayList;
//import java.util.Arrays;

public class TesterClass {

	public static void main(String[] args)
	{	
		

		ClimateAnalyzer testMethods = new ClimateAnalyzer("world_temp_2000-2016.csv");
		testMethods.runClimateAnalyzer();
		
		//REMEMBER TO ADD COMMENTS AND CHANGE ",    " space
		//WeatherIO test1 = new WeatherIO();
		//test1.readDataFromFile("world_temp_2000-2016.csv");
		
		
		//ArrayList<ITemperature> testList = test1.readDataFromFile("world_temp_2000-2016.csv");
		//String filename = "filename";
		//String topic = "TEST";
		//String subject = "this is my subject";
		
		//test1.writeSubjectHeaderInFile(filename, subject);
		//test1.writeDataToFile(filename, topic, testList);
		
		//System.out.println(testMethods.getLowestTempByYear("Albania", 2016).getTemperature(false));
		
//		ArrayList<ITemperature> topTen = testMethods.allCountriesTop10TempDelta(10,2004,2016);
//		for (ITemperature temp : topTen)
//		{
//			System.out.println(temp.getTemperature(false)+temp.getCountry()+temp.getYear());
//		}
		//System.out.println(testMethods.allCountriesGetTop10LowestTemp(10));
		
	}
}
