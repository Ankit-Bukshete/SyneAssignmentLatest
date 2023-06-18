//package com.pages;
//
////import org.junit.Assert;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//import java.awt.*;
//import java.awt.event.KeyEvent;
//
//public class AdminPage {
//
//
//    @FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
//    private WebElement adminTab;
//
//    @FindBy(xpath = "//*[@class='orangehrm-header-container']/button")
//    private WebElement addButton;
//
//    @FindBy(xpath = "//button[contains(.,'Search')]")
//    private WebElement searchBtn;
//
//    @FindBy(xpath = "//button[@type='submit']")
//    private WebElement loginBtn;
//
//    @FindBy(xpath = "//div//label[contains(.,'Username')]//..//..//input")
//    protected WebElement usernameInput;
//
//    @FindBy(css = ".oxd-grid-item:nth-of-type(1) .oxd-select-text.oxd-select-text")
//    protected WebElement userRoleSelect;
//
//    @FindBy(xpath = "//div[@class='oxd-autocomplete-wrapper']/div/input")
//    protected WebElement employeeName;
//
//    @FindBy(css = ".oxd-grid-item:nth-of-type(3) .oxd-select-text.oxd-select-text")
//    protected WebElement userStatusSelect;
//
//    @FindBy(xpath = "//div//label[contains(.,'Current')]//..//..//input")
//    protected WebElement currentPasswordInput;
//
//    @FindBy(xpath = "//div//label[not(contains(.,'Confirm'))]//..//..//input[@autocomplete='off'][contains(@type,'password')]")
//    protected WebElement passwordInput;
//
//    @FindBy(xpath = "//div//label[contains(.,'Confirm')]//..//..//input")
//    protected WebElement confirmPasswordInput;
//
//    @FindBy(xpath = "//button[contains(.,'Save')]")
//    protected WebElement saveBtn;
//
//    @FindBy(css = ".oxd-userdropdown-name")
//    protected WebElement loggedInUser;
//
//    @FindBy(css = ".oxd-toast--success")
//    protected WebElement successMessage;
//
//
//    //    public AdminPage(WebDriver driver) {
////        PageFactory.initElements(driver, this);
////    }
//    public void AddUser(String username, String password) throws AWTException, InterruptedException {
//
//        Robot robot = new Robot();
//        adminTab.click();
//        addButton.click();
//
//        userRoleSelect.click();
//        robot.keyPress(KeyEvent.VK_DOWN);
//        robot.keyRelease(KeyEvent.VK_DOWN);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyRelease(KeyEvent.VK_TAB);
//
//        userStatusSelect.click();
//        robot.keyPress(KeyEvent.VK_DOWN);
//        robot.keyRelease(KeyEvent.VK_DOWN);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyRelease(KeyEvent.VK_TAB);
//
////        employeeName.sendKeys(name);
//        usernameInput.sendKeys(username);
//        passwordInput.sendKeys(password);
//        confirmPasswordInput.sendKeys(password);
//
//        employeeName.sendKeys(loggedInUser.getText().split(" ")[0]+" ");
//        Thread.sleep(5000);
//        robot.keyPress(KeyEvent.VK_DOWN);
//        robot.keyRelease(KeyEvent.VK_DOWN);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//
//        saveBtn.click();
//    }
//
//    public void verifySuccessMessage(){
////        Assert.assertEquals("The message is not displayed",true,successMessage.isDisplayed());
//    }
//}


package com.pages;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.logging.Logger;

public class AdminPage {

    private WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(AdminPage.class.getName());


    // 1. By Locators: OR

    private By adminTab = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    ;
    private By addButton = By.xpath("//*[@class='orangehrm-header-container']/button");

    private By searchBtn = By.xpath("//button[contains(.,'Search')]");

    private By loginBtn = By.xpath("//button[@type='submit']");

    private By usernameInput = By.xpath("//div//label[contains(.,'Username')]//..//..//input");

    private By userRoleSelect = By.cssSelector(".oxd-grid-item:nth-of-type(1) .oxd-select-text.oxd-select-text");

    private By employeeName = By.xpath("//div[@class='oxd-autocomplete-wrapper']/div/input");

    private By userStatusSelect = By.cssSelector(".oxd-grid-item:nth-of-type(3) .oxd-select-text.oxd-select-text");

    private By currentPasswordInput = By.xpath("//div//label[contains(.,'Current')]//..//..//input");

    private By passwordInput = By.xpath("//div//label[not(contains(.,'Confirm'))]//..//..//input[@autocomplete='off'][contains(@type,'password')]");

    private By confirmPasswordInput = By.xpath("//div//label[contains(.,'Confirm')]//..//..//input");

    private By saveBtn = By.xpath("//button[contains(.,'Save')]");

    private By loggedInUser = By.cssSelector(".oxd-userdropdown-name");

    private By successMessage = By.cssSelector(".oxd-toast--success");


    // 2. Constructor of the page class:
    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. page actions: features(behavior) of the page the form of methods:

    public String getLoginPageTitle() {
        return driver.getTitle();
    }


    public void clickOnLogin() {
        driver.findElement(loginBtn).click();
    }

    public void AddUser(String username, String password) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        driver.findElement(adminTab).click();
        LOGGER.info("Admin tab clicked");
        driver.findElement(addButton).click();
        LOGGER.info("Add button clicked");
        driver.findElement(userRoleSelect).click();
        robot.keyPress(KeyEvent.VK_DOWN);

        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        LOGGER.info("Admin Role is selected");


        driver.findElement(userStatusSelect).click();

        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        LOGGER.info("User status is selected");

        driver.findElement(usernameInput).sendKeys(username);
        LOGGER.info("Username - " + username);

        driver.findElement(passwordInput).sendKeys(password);
        LOGGER.info("Password is entered");
        driver.findElement(confirmPasswordInput).sendKeys(password);
        LOGGER.info("Confirm Password is entered");
        String loggedInUserName = driver.findElement(loggedInUser).getText();

        driver.findElement(employeeName).sendKeys(loggedInUserName.split(" ")[0] + " ");

        LOGGER.info("loggedInUserName - " + loggedInUserName);

        Thread.sleep(5000);
        robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        driver.findElement(saveBtn).click();
        LOGGER.info("Save button is clicked");


    }

    public void verifySuccessMessage(){
//        driver.findElement(successMessage).isDisplayed();
//        LOGGER.info("Success message is displayed");
    }

}
