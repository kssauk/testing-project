package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 21.12.2015.
 */
public class AddNewFriendPage extends AbstractPage{

    private final String BASE_URL = "https://ask.fm/login";
    private final String USERNAME3 = "KseniyaSauk";
    private final Logger logger = Logger.getLogger(AddNewFriendPage.class);

    public AddNewFriendPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }


    @FindBy(xpath = "//a[@href='/account/friends']")
    private WebElement buttonFriends;

    @FindBy(xpath = "//div[@id='searchResults']//a[@href='/account/search']")
    private WebElement buttonFindFriends;

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement inputFriendName;

    @FindBy(xpath = "//a[@data-action='FollowToggle']")
    private WebElement buttonAddFriend;

    @FindBy(xpath = "//a[@class='askfm-avatar45']")
    private WebElement buttonFriend;

    @FindBy(xpath = "//span[@class='blockLink foot bold']//span[@dir='ltr']")
    private WebElement linkLoggedInUser;

    @FindBy(xpath = "//a[@class='profileButton baseButton-grey']")
    private WebElement buttonUnfollow;

    public List<String> addNewFriend () throws InterruptedException {
        buttonFriends.click();
        logger.info("Open page Friends");
        buttonFindFriends.click();
        Thread.sleep(2000);
        inputFriendName.sendKeys(USERNAME3);
        Thread.sleep(2000);
        buttonAddFriend.click();
        logger.info("New friend added");
        Thread.sleep(2000);
        logger.info("Page Friends open again");
        buttonFriends.click();
        Thread.sleep(2000);
        inputFriendName.sendKeys(USERNAME3);
        Thread.sleep(2000);
        buttonFriend.click();

        List<String> friend = new ArrayList<String>();
        friend.add('@'+USERNAME3);
        friend.add(linkLoggedInUser.getText());
        return friend;
    }

    public void unfollowUser() throws InterruptedException {
        buttonFriends.click();
        Thread.sleep(2000);
        inputFriendName.sendKeys(USERNAME3);
        Thread.sleep(2000);
        buttonFriend.click();
        Thread.sleep(2000);
        buttonUnfollow.click();
        logger.info("Unfollow user");
    }
}
