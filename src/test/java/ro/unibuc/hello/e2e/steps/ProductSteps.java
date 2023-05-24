package ro.unibuc.hello.e2e.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


//@SpringBootTest()
public class ProductSteps {

//    public static ResponseResults latestResponse = null;
//    @Autowired
//    protected RestTemplate restTemplate;
//
//
//    @Given("^the admin calls /product")
//    public void the_client_issues_POST_product() {
//        executePost("http://localhost:8080/product");
//    }
//
//    @Then("^the client receives status code of (\\d+)$")
//    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
//        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
//        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
//    }
//
//    @And("^the client receives response (.+)$")
//    public void the_client_receives_response(String response) throws JsonProcessingException {
//        String latestResponseBody = latestResponse.getBody();
//        Greeting greeting = new ObjectMapper().readValue(latestResponseBody, Greeting.class);
//        assertThat("Response received is incorrect", greeting.getContent(), is(response));
//    }
//
//
//
//    public void executePost(String url) {
//        final Map<String, String> headers = new HashMap<>();
//        headers.put("Accept", "application/json");
//        final HeaderSetup requestCallback = new HeaderSetup(headers);
//        final ResponseErrorHandler errorHandler = new ResponseErrorHandler();
//
//        restTemplate.setErrorHandler(errorHandler);
//        latestResponse = restTemplate.execute(url, HttpMethod.POST, requestCallback, response -> {
//            if (errorHandler.getHadError()) {
//                return (errorHandler.getResults());
//            } else {
//                return (new ResponseResults(response));
//            }
//        });
//    }

}
