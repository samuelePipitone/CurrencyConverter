package myObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GetObject {

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String makeCall() throws Exception {
		
		String jsonData = "";
		
		//GET Logic
		try {
			URL urlForGetRequest = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
			connection.setRequestMethod("GET");
			int responseCode = connection.getResponseCode();
	
			if (responseCode == HttpURLConnection.HTTP_OK) {
			Scanner scanner = new Scanner(urlForGetRequest.openStream());
			while (scanner.hasNext()) {
				      jsonData += scanner.nextLine();
				  }
				  scanner.close();
			}
				 
	} catch(Exception e) {
		throw new Exception("Error");
		}
		return jsonData;
	}
	
}
