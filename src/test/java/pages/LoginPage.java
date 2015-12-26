package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by PC on 20.12.2015.
 */
public class LoginPage extends AbstractPage{

    private final Logger logger = Logger.getLogger(LoginPage.class);
    private final String BASE_URL = "https://ask.fm/login";


   // @FindBy(xpath = "//a[@class='button buttonLarge buttonBlue']")
   // private WebElement buttonLogIn;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//a[@href='/TestingProject']")
    private WebElement buttonProfile;

//    @FindBy(xpath = "//span[contains(.,'TestingProject')]")
//    private WebElement linkLoggedInUser;

    @FindBy(xpath = "//span[@class='blockLink foot bold']//span[@dir='ltr']")
    private WebElement linkLoggedInUser;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage(){
        driver.navigate().to(BASE_URL);
        logger.info("Loggin page opened");
    }

    public void login(String username, String password){

        //buttonLogIn.click();
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        buttonProfile.click();
        logger.info("Login formed");
    }

    public String getLoggedInUserName(){
        return linkLoggedInUser.getText();
    }
}
