package stepDefinitions;

import static io.restassured.RestAssured.given;

import pojo.Login;
import pojo.LoginResponse;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;

public class StepDefinition {

	RequestSpecification req;
	RequestSpecification loginReqest;
	LoginResponse loginResponse;

	@Given("Login payload")
	public void login_payload() {
		req =new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		
		Login login = new Login();
		login.setUserEmail("nov9@yopmail.com");
		login.setUserPassword("Asdfg1@34");
		
		loginReqest =given().log().all().spec(req).body(login);

	}

	@When("user calls {string} with POST HTTP request")
	public void user_calls_with_post_http_request(String string) {

		loginResponse=loginReqest.when().post("/api/ecom/auth/login")
				.then().log().all().extract().as(LoginResponse.class);
	}

	@Then("the API call got success with  {int}")
	public void the_api_call_got_success_with(Integer int1) {

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
