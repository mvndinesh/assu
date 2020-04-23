package reusablefunctions;
import org.apache.http.client.RedirectStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import accessvariables.Accessvariables;


public class BaseReusableFunctions {

	public Response getGivenResponse(HashMap<String,Object> argHeaderParams,HashMap<String,Object> argParams,String strUrl) {
		Response response = given().headers(argHeaderParams).params(argParams).get(strUrl);
		return response;
	}


	// The post is explicitly re-directed due to 301. 
	public Response postGivenResponse(HashMap<String,Object> argHeaderParams,HashMap<String,Object> argParams,String strUrl) {
		RestAssured.baseURI = Accessvariables.postBaseURI;
		RedirectStrategy redirectStrategy = new DefaultRedirectStrategy() {
			@Override
			protected boolean isRedirectable(String method) {
				return true;
			}
		};

		RestAssured.config = RestAssured.config().httpClient(HttpClientConfig.httpClientConfig().httpClientFactory(() -> {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			httpClient.setRedirectStrategy(redirectStrategy);
			return httpClient;
		}));

		Response response = given().headers(argHeaderParams).params(argParams).post(strUrl);
		return response;
	}	




}
