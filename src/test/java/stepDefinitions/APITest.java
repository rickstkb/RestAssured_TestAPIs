package stepDefinitions;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.containsString;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class APITest {
	
	String resource;
	
	@Given("^I have set the base URL$")
	public void i_have_set_the_base_URL() throws Throwable {
		baseURI = "http://services.groupkt.com/country/get";
//	    throw new PendingException();
	}

	@When("^I have set the resource to \"([^\"]*)\"$")
	public void i_have_set_the_resource_to(String arg1) throws Throwable {
		resource = arg1;
//	    throw new PendingException();
	}
	
	@When("^I have set the resource to base resource$")
	public void i_have_set_the_resource_to_base_resource() throws Throwable {
		resource = "/";
//		throw new PendingException();
	}

	@Then("^the result should contain \"([^\"]*)\"$")
	public void the_result_should_contain(String arg1) throws Throwable {
		given().when().get(resource).then().statusCode(200).body("RestResponse.result.alpha2_code", hasItem(arg1));
//	    throw new PendingException();
	}
	
	@Then("^the result of name, alpha2_code and alpha3_code should be \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_result_should_be_and(String arg1, String arg2, String arg3) throws Throwable {
		given().when().get(resource).then().statusCode(200).body("RestResponse.result.name", equalTo(arg1));
		given().when().get(resource).then().statusCode(200).body("RestResponse.result.alpha2_code", equalTo(arg2));
		given().when().get(resource).then().statusCode(200).body("RestResponse.result.alpha3_code", equalTo(arg3));
//	    throw new PendingException();
	}

	@Then("^the result should not contain \"([^\"]*)\"$")
	public void the_result_should_not_contain(String arg1) throws Throwable {
		given().when().get(resource).then().statusCode(200).body("RestResponse.result.alpha2_code", not(hasItem(arg1)));
//	    throw new PendingException();
	}
	
	@Then("^the result should inform \"([^\"]*)\"$")
	public void the_result_should_inform(String arg1) throws Throwable {
		String myJson = "{\"name\":\"Test Country\",\"alpha2_code\":\"TC\",\"alpha3_code\":\"TCY\"}";
		given().contentType("application/json").body(myJson).when().post(resource).then().statusCode(200).body("message",
				containsString(arg1));
//	    throw new PendingException();
	}
}
