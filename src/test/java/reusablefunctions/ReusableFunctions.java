package reusablefunctions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.gson.JsonParser;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import accessvariables.Accessvariables;

public class ReusableFunctions extends BaseReusableFunctions {

	private String strJokersEnabled = "false";
	private String strUrl;
	private int intExpectedRemaingCards;
	private int intCountCardDraw;
	private int intExpectedStatusCode;
	private HashMap<String,Object> hmapheaders;
	private HashMap<String,Object> hmapparams;


	public String getStrJokersEnabled() {
		return this.strJokersEnabled;
	}

	public void setStrJokersEnabled(String argSetStrJokersEnabled) {
		this.strJokersEnabled = argSetStrJokersEnabled;
	}

	public String getStrUrl() {
		return this.strUrl;
	}

	public void setStrUrl(String argStrUrl) {
		this.strUrl = argStrUrl;
	}

	public int getIntExpectedRemaingCards() {
		return this.intExpectedRemaingCards;
	}

	public void setIntExpectedRemaingCards(int argSetIntExpectedRemaingCards) {
		this.intExpectedRemaingCards = argSetIntExpectedRemaingCards;
	}

	public int getIntExpectedStatusCode() {
		return this.intExpectedStatusCode;
	}

	public void setIntExpectedStatusCode(int argIntExpectedStatusCode) {
		this.intExpectedStatusCode = argIntExpectedStatusCode;
	}

	public int getIntCountCardDraw() {
		return this.intCountCardDraw;
	}

	public void setIntCountCardDraw(int argSetIntCountCardDraw) {
		this.intCountCardDraw = argSetIntCountCardDraw ;
	}

	public void setHmapHeaders(HashMap<String,Object> hmapheaders) {
		this.hmapheaders = hmapheaders;
	}

	public void setHmapParams(HashMap<String,Object> hmapparams) {
		this.hmapparams = hmapparams;
	}


	public boolean getDeckOfCards() {
		Response response = getGivenResponse(hmapheaders,hmapparams,strUrl);
		if (response.getStatusCode() != 200) {
			return false;
		} 
		response.then().
		statusCode(this.intExpectedStatusCode).
		body("success",equalTo(true)).
		body("remaining",equalTo(this.intExpectedRemaingCards)).
		log().all();

		return true;
	}

	public boolean postCreateNewDeckOfCards() {
		Response response = postGivenResponse(hmapheaders,hmapparams,strUrl);
		if (response.getStatusCode() != 200) {
			return false;
		}
		response.then().
		body("success",equalTo(true)).
		statusCode(this.intExpectedStatusCode).
		log().all();
		return true;

	}

}
