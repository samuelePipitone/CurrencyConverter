package main;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Test {

	public static void main(String[] args) throws Exception {
		
		//Variables
		String firstCurrency;
		String secondCurrency;
		String jsonData = "";
		String apiKey = "c67a38c0-8846-11ec-8f4c-f74ccebf4e0d";
		
		//Open Scanner
		Scanner sc = new Scanner(System.in);
		
		//Text
		System.out.println("Hello! welcome to my real time currency converter");
		System.out.println("Please select your actual currency");
		
		//User Input
		firstCurrency = sc.nextLine();
		System.out.println("Perfect! got it. Now select the currency you want to convert to");
		secondCurrency = sc.nextLine();
		System.out.println("insert the quantity you want to convert");
		String prova = sc.nextLine();
		double daje = Double.parseDouble(prova);
		sc.close();
		
		String url = "https://freecurrencyapi.net/api/v2/latest?apikey=" + apiKey
				+ "&base_currency=" + firstCurrency;
		
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
		
		//Take the JSON and transform it into JSONObject
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonData);
		JSONObject jobj = (JSONObject)obj;
		
		//Take JSONObject and get inside the nested object "data"
		JSONObject jData = (JSONObject) jobj.get("data");
		
		//System.out.println(jData);
		
		//Conversion logic
		double conversion = (double) jData.get(secondCurrency); 
		double total = daje*conversion;
		System.out.println("Your total is: " + total);
		
	}
}
	



















