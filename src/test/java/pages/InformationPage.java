package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 23.12.2015.
 */
public class InformationPage extends AbstractPage {

    private final String BASE_URL = "https://ask.fm/login";
    private final String LOCATION = "Minsk";
    private final Logger logger = Logger.getLogger(InformationPage.class);

    public InformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    @FindBy(xpath = "//ul[@class='desktop-menu']//li[@id='desktop-menu-icon']//a[@href='/account/settings/profile']")
    private WebElement buttonSettings;

    @FindBy(xpath = "//input[@id='user_location']")
    private WebElement inputLocation;

    @FindBy(xpath = "//input[@value='Сохранить']")
    private WebElement buttonSave;

    @FindBy(xpath = "//a[@href='/TestingProject']")
    private WebElement buttonProfile;

    @FindBy(xpath = "//div[@class='aboutMore']//p")
    private WebElement textAboutMore;

    public List<String> addNewInformation(){

        buttonSettings.click();
        logger.info("Open Settings page");
        inputLocation.clear();
        inputLocation.sendKeys(LOCATION);
        logger.info("Added New location");
        buttonSave.click();
        logger.info("New location save");
        buttonProfile.click();

        List<String> locations = new ArrayList<String>();
        locations.add(LOCATION);
        locations.add(textAboutMore.getText());
        return locations;
    }


}
