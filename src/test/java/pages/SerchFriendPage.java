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
public class SerchFriendPage extends AbstractPage {

    private final String BASE_URL = "https://ask.fm/login";
    private final String USERNAME2 = "TestingProject2";
    private final Logger logger = Logger.getLogger(InformationPage.class);

    public SerchFriendPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public void openPage() {

        driver.navigate().to(BASE_URL);
    }

    @FindBy(xpath = "//a[@href='/account/friends']")
    private WebElement buttonFriends;

//    @FindBy(xpath = "//div[@id='searchResults']//a[@href='/account/search']")
//    private WebElement buttonFindFriends;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement inputFriendName;

    @FindBy(xpath = "//a[@class='askfm-avatar45']")
    private WebElement buttonFriend;

    @FindBy(xpath = "//span[@class='blockLink foot bold']//span[@dir='ltr']")
    private WebElement linkLoggedInUser;

    public List<String> findFriend () throws InterruptedException {

        buttonFriends.click();
        logger.info("Open page Friends");
        //buttonFindFriends.click();
        inputFriendName.sendKeys(USERNAME2);
        Thread.sleep(2000);

        buttonFriend.click();

        List<String> friend = new ArrayList<String>();
        friend.add('@'+USERNAME2);
        friend.add(linkLoggedInUser.getText());
        return friend;
    }
}
