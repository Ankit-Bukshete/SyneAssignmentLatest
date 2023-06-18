package stepdefinitions;


import com.pages.AdminPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.log4testng.Logger;

import java.awt.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;


public class AdminStepDef {

    private static final Logger LOGGER = Logger.getLogger(AdminStepDef.class.getName().getClass());

    private LoginPage loginPage;
    private AdminPage adminPage;

//    public static Properties config;


    public AdminStepDef(){
        loginPage = new LoginPage(DriverFactory.getDriver());
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        LOGGER.info("Website is launched successfully");
    }
    @When("the user enters the {string} and {string}")
    public void the_user_enters_the_and(String username, String password) {
        adminPage=loginPage.doLogin(username, password);
        LOGGER.info(username+ " user logged in successfully...");
    }

    @When("the user adds new Admin {string}")
    public void the_user_adds_new_admin( String username) throws AWTException, InterruptedException {
        String randomString = generateRandomString();
        adminPage.AddUser( username + randomString, "pwd"+randomString);
    }

    private String generateRandomString() {

        int min = 10000;
        int max = 40000;

        System.out.println("Random value of type double between " + min + " to " + max + ":");
        double a = Math.random() * (max - min + 1) + min;
        System.out.println(a);

        System.out.println("Random value of type int between " + min + " to " + max + ":");
        int b = (int) (Math.random() * (max - min + 1) + min);
        System.out.println(b);
        return Integer.toString(b);
    }

    @Then("add user success message should be displayed")
    public void add_user_success_message_should_be_displayed() {
        adminPage.verifySuccessMessage();

    }
}
