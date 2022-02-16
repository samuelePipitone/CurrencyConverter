package main;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import myObjects.Currencies;
import myObjects.GetObject;

public class Test {

	public static void main(String[] args) throws Exception {
		
		//Variables
		String firstCurrency;
		String secondCurrency;
		String jsonData = "";
		String apiKey = "c67a38c0-8846-11ec-8f4c-f74ccebf4e0d";
		String listChoose;
		String chooseLoop = "yes";
		
		//singleton
		Scanner sc = new Scanner(System.in);
		Currencies currencies = new Currencies();
		DecimalFormat df = new DecimalFormat("#.##");
		GetObject go = new GetObject();
		
		List<String> scelta = currencies.createList();
		
		while(chooseLoop.equals("yes")) {
			//Text
			System.out.println("Hello! welcome to my real time currency converter");
			System.out.println("If you want a list of currencies digit y, else type any key");
			//User Input
			listChoose = sc.nextLine();
			if(listChoose.equals("y") || listChoose.equals("yes")) {
				for(String valuta : scelta) {
					System.out.println(valuta);
				}
			}
			
		//Text
		System.out.println("\n");
		System.out.println("Select the currency you want to convert from");
		firstCurrency = sc.nextLine();
		System.out.println("Perfect! got it. Now select the currency you want to convert to");
		secondCurrency = sc.nextLine();
		System.out.println("insert the quantity you want to convert");
		String prova = sc.nextLine();
		double daje = Double.parseDouble(prova);
				
		go.setUrl("https://freecurrencyapi.net/api/v2/latest?apikey=" + apiKey + "&base_currency=" + firstCurrency);
			
		jsonData = go.makeCall();
			
		//Take the JSON and transform it into JSONObject
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonData);
		JSONObject jobj = (JSONObject)obj;
				
		//Take JSONObject and get inside the nested object "data"
		JSONObject jData = (JSONObject) jobj.get("data");
				
		//Conversion logic
		double conversion = (double) jData.get(secondCurrency); 
		double total = daje*conversion;
		System.out.println("Your total is: " + df.format(total));
		System.out.println("If you want to convert another value digit yes, else digit any key");
		chooseLoop = sc.nextLine();
		System.out.println("\n");
		}	
		System.out.println("\n");
		System.out.println("Thank you for use my little application");
		sc.close();
	}
}
	



















