package apitesting;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import reusablefunctions.ReusableFunctions;
import accessvariables.Accessvariables;


public class ApiTestsGET {
	private HashMap<String,Object> hmapheaders = new HashMap<String,Object>();
	private HashMap<String,Object> hmapparams = new HashMap<String,Object>();;
	private ReusableFunctions objReusableFunctions = new ReusableFunctions();

	// To validate the cards in the pack,status code when the Jokers Enabled = False 
	@Test
	public void getCreateNewDeckOfCards01() {
		hmapheaders.put("Content-Type" , "application/json");
		hmapparams.put("jokers_enabled","false");

		objReusableFunctions.setHmapHeaders(hmapheaders);
		objReusableFunctions.setHmapParams(hmapparams);
		objReusableFunctions.setIntExpectedRemaingCards(52);
		objReusableFunctions.setStrUrl(Accessvariables.getNewDeckOfCardsURL);
		objReusableFunctions.setIntExpectedStatusCode(200);

		boolean booReturnValue = objReusableFunctions.getDeckOfCards();
		AssertJUnit.assertEquals(true, booReturnValue);	
	}

	// To validate the cards in the pack,status code when the Jokers Enabled = True 
	@Test
	public void getCreateNewDeckOfCards02() {	
		hmapheaders.put("Content-Type" , "application/json");
		hmapparams.put("jokers_enabled","true");

		objReusableFunctions.setHmapHeaders(hmapheaders);
		objReusableFunctions.setHmapParams(hmapparams);
		objReusableFunctions.setIntExpectedRemaingCards(54);
		objReusableFunctions.setStrUrl(Accessvariables.getNewDeckOfCardsURL);
		objReusableFunctions.setIntExpectedStatusCode(200);

		boolean booReturnValue = objReusableFunctions.getDeckOfCards();
		AssertJUnit.assertEquals(true, booReturnValue);	

	}

	// Draw 10 cards from the pack and Jokers = false, validate the remaining cards count : 42.
	@Test
	public void getDrawOneOrMoreCards03() {
		hmapheaders.put("Content-Type" , "application/json");
		hmapparams.put("jokers_enabled","false");
		hmapparams.put("count",10);

		objReusableFunctions.setHmapHeaders(hmapheaders);
		objReusableFunctions.setHmapParams(hmapparams);
		objReusableFunctions.setIntExpectedRemaingCards(42);
		objReusableFunctions.setStrUrl(Accessvariables.getDrawOneorMoreURL);
		objReusableFunctions.setIntExpectedStatusCode(200);

		boolean booReturnValue = objReusableFunctions.getDeckOfCards();
		AssertJUnit.assertEquals(true, booReturnValue);	

	}

	// Draw 22 cards from the pack and validate the remaining cards count : 30.
	@Test
	public void getDrawOneOrMoreCards04() {
		hmapheaders.put("Content-Type" , "application/json");
		hmapparams.put("jokers_enabled","false");
		hmapparams.put("count",22);

		objReusableFunctions.setHmapHeaders(hmapheaders);
		objReusableFunctions.setHmapParams(hmapparams);
		objReusableFunctions.setIntExpectedRemaingCards(30);
		objReusableFunctions.setStrUrl(Accessvariables.getDrawOneorMoreURL);
		objReusableFunctions.setIntExpectedStatusCode(200);

		boolean booReturnValue = objReusableFunctions.getDeckOfCards();
		AssertJUnit.assertEquals(true, booReturnValue);				

	}

	// Draw 10 cards from the pack and Jokers = true, validate the remaining cards count : 44.
	@Test
	public void getDrawOneOrMoreCards05() {
		hmapheaders.put("Content-Type" , "application/json");
		hmapparams.put("jokers_enabled","true");
		hmapparams.put("count",10);

		objReusableFunctions.setHmapHeaders(hmapheaders);
		objReusableFunctions.setHmapParams(hmapparams);
		objReusableFunctions.setIntExpectedRemaingCards(44);
		objReusableFunctions.setStrUrl(Accessvariables.getDrawOneorMoreURL);
		objReusableFunctions.setIntExpectedStatusCode(200);

		boolean booReturnValue = objReusableFunctions.getDeckOfCards();
		AssertJUnit.assertEquals(true, booReturnValue);	
	}

	// Draw 22 cards from the pack and Jokers = true, validate the remaining cards count : 32.
	@Test
	public void getDrawOneOrMoreCards06() {
		hmapheaders.put("Content-Type" , "application/json");
		hmapparams.put("jokers_enabled","true");
		hmapparams.put("count",22);

		objReusableFunctions.setHmapHeaders(hmapheaders);
		objReusableFunctions.setHmapParams(hmapparams);
		objReusableFunctions.setIntExpectedRemaingCards(32);
		objReusableFunctions.setStrUrl(Accessvariables.getDrawOneorMoreURL);
		objReusableFunctions.setIntExpectedStatusCode(200);

		boolean booReturnValue = objReusableFunctions.getDeckOfCards();
		AssertJUnit.assertEquals(true, booReturnValue);	
	}
	
	// Pass negative count to draw from the deck and verify if remaining cards are 5, as the count(-5) is equal to count(47)
	@Test
	public void getDrawOneOrMoreCards07() {
		hmapheaders.put("Content-Type" , "application/json");
		hmapparams.put("jokers_enabled","false");
		hmapparams.put("count",-5);

		objReusableFunctions.setHmapHeaders(hmapheaders);
		objReusableFunctions.setHmapParams(hmapparams);
		objReusableFunctions.setIntExpectedRemaingCards(5);
		objReusableFunctions.setStrUrl(Accessvariables.getDrawOneorMoreURL);
		objReusableFunctions.setIntExpectedStatusCode(200);

		boolean booReturnValue = objReusableFunctions.getDeckOfCards();
		AssertJUnit.assertEquals(true, booReturnValue);	

	}
	

	//Negative test case : Verify if the wrong URL is handled appropriately by the API.
	@Test
	public void getDrawOneOrMoreCards08() {
		hmapheaders.put("Content-Type" , "application/json");
		hmapparams.put("jokers_enabled","true");
		hmapparams.put("count",12);

		objReusableFunctions.setHmapHeaders(hmapheaders);
		objReusableFunctions.setHmapParams(hmapparams);
		objReusableFunctions.setIntExpectedRemaingCards(42);
		objReusableFunctions.setStrUrl("https://deckofcardsapi.com/api/deck/new/dr/");
		objReusableFunctions.setIntExpectedStatusCode(200);

		boolean booReturnValue = objReusableFunctions.getDeckOfCards();
		AssertJUnit.assertEquals(false, booReturnValue);	
	}

	//Negative test case : Verify if the wrong headers are handled appropriately by the API.
	@Test
	public void getDrawOneOrMoreCards09() {
		hmapheaders.put("Content-Ty" , "application/json");
		hmapparams.put("jokers_enabled","true");
		hmapparams.put("count",22);

		objReusableFunctions.setHmapHeaders(hmapheaders);
		objReusableFunctions.setHmapParams(hmapparams);
		objReusableFunctions.setIntExpectedRemaingCards(32);
		objReusableFunctions.setStrUrl("https://deckofcardsapi.com/api/deck/new/dr/");
		objReusableFunctions.setIntExpectedStatusCode(200);

		boolean booReturnValue = objReusableFunctions.getDeckOfCards();
		AssertJUnit.assertEquals(false, booReturnValue);	
	}

	// Negative test case : Verify if wrong parameters are handled appropriately by the API.
	@Test
	public void getDrawOneOrMoreCards10() {
		hmapheaders.put("Content-Type" , "application/json");
		hmapparams.put("jokers_enab","true");
		hmapparams.put("count",22);

		objReusableFunctions.setHmapHeaders(hmapheaders);
		objReusableFunctions.setHmapParams(hmapparams);
		objReusableFunctions.setIntExpectedRemaingCards(32);
		objReusableFunctions.setStrUrl("https://deckofcardsapi.com/api/deck/new/dr/");
		objReusableFunctions.setIntExpectedStatusCode(200);

		boolean booReturnValue = objReusableFunctions.getDeckOfCards();
		AssertJUnit.assertEquals(false, booReturnValue);	

	}
	

	


}
