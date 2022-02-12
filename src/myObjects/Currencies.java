package myObjects;

import java.util.ArrayList;
import java.util.List;

public class Currencies {
	
	private List<String> scelta2 = new ArrayList<String>();
	
	public Currencies() {}

	public List<String> createList(){	
		List<String> scelta = new ArrayList<String>();
		
		//statically added currencies
		scelta.add("EUR for Euro");
		scelta.add("USD for American dollar");
		scelta.add("GBP for Sterlin");
		scelta.add("CAD for Canadian dollar");
		scelta.add("AUD for Australian dollar");
		scelta.add("JPY for Japanese yen");
		scelta.add("CHF for Swiss franc");
		scelta.add("HKD for South Corea won");
		scelta.add("SGD for Singapore dollar");
		scelta.add("NOK for Norvegian krone");
		scelta.add("INR for Indian ruble");
		scelta.add("ZAR for South Africa rand");
		scelta.add("Search for more...");
		return scelta;
	}

	public List<String> getScelta() {
		return scelta2;
	}
	
}
