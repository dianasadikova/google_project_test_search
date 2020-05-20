package integrationtests.cucumbers.googleSearch;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"integrationtests.cucumbers.googleSearch", "cucumber.api.spring"},
        tags = "@GoogleSearch")
public class GoogleSearchRunTest {
}
