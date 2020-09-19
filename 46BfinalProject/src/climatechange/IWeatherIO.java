package climatechange;

import java.util.ArrayList;

public interface IWeatherIO {

	public ArrayList<ITemperature> readDataFromFile(String fileName);
	
	 public void writeSubjectHeaderInFile(String filename, String subject);
	 public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList);
	 
}
