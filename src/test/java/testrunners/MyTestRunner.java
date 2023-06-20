package testrunners;

import org.junit.runner.RunWith;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( plugin ={"pretty", "html:target/cucumber", "json:target/cucumber.json"})

public class MyTestRunner {

}
