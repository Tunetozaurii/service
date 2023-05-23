package ro.unibuc.hello.e2e;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import ro.unibuc.hello.HelloApplication;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Cond.when;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(features = "src/test/java/ro/unibuc/hello/e2e", glue = "ro.unibuc.hello.e2e.steps")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HelloWorldE2E {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldE2E.class);

    @Before
    public final void setup() {
        mockStatic(SpringApplication.class);

    }

}