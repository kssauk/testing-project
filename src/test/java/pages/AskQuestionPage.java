package pages;

import org.openqa.selenium.WebDriver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import steps.Steps;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by PC on 20.12.2015.
 */
public class AskQuestionPage extends AbstractPage {
    private final String BASE_URL = "https://ask.fm/login";
    private final String USERNAME2 = "TestingProject2";
    private final String PASSWORD2 = "testing123";
    private static final String HOW_DO_YOU_DO = "How do you do?";


    private final Logger logger = Logger.getLogger(AskQuestionPage.class);
   // private Steps steps = new Steps();

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    @FindBy(xpath = "//div[@id='lightboxBody']//form[@id='askForm']//div[@class='question']//textarea[@id='question_question_text']")
    private WebElement inputNewQuestion;

    @FindBy(xpath = "//div[@class='optionsBar']//input[@class='optionsBar-submit rsp-eql-desktop']")
    private WebElement buttonAskFriend;

    @FindBy(xpath = "//div[@class='searchFormPadding']//input[@class='searchForm']")
    private WebElement inputFriendName;

    @FindBy(xpath = "//div[@class='item-pager ']//a[@class='item streamItem streamItem-user']//div[@class='askfm-avatar45']")
    private WebElement buttonFriend;

    @FindBy(xpath = "//div[@class='optionsBar']//input[@class='optionsBar-submit']")
    private WebElement buttonAsk;

    @FindBy(xpath = "//ul[@class='desktop-menu']//li[@id='desktop-menu-icon']//a[@href='/account/settings/profile']")
    private WebElement buttonSettings;

    @FindBy(xpath = "//nav[@class='subTabBar']//a[@href='/account/settings/account']")
    private WebElement buttonAccount;

    @FindBy(xpath = "//div[@class='accountSettings']//a[@data-action='ButtonPostOnce']")
    private WebElement buttonExit;

    @FindBy(xpath = "//div[@class='blue-button-container']//a[@class='button buttonLarge buttonBlue']")
    private WebElement buttonLog;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//a[@href='/account/notifications']")
    private WebElement buttonNotifications;

    @FindBy(xpath = "//div[@class='item streamItem streamItem-notification']")
    private WebElement buttonAnswerQuestion;

    @FindBy(xpath = "//form[@id='answerForm']//div[@class='question']")
    private WebElement lastQuestion;

    @FindBy(xpath = "//a[@data-action='CookieNoticeAccept']")
    private WebElement buttonCloseCookie;

    public AskQuestionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public List<String> askNewQuestion() throws InterruptedException {
       // String questionFullText = Utils.getRandomString(6);
        logger.info("Asking page opened");
        buttonAskFriend.click();
        inputNewQuestion.sendKeys(HOW_DO_YOU_DO);
        inputFriendName.click();
        buttonFriend.click();
        buttonAsk.click();

        Thread.sleep(2000);
        buttonSettings.click();
        buttonSettings.click();
        Thread.sleep(2000);
        buttonCloseCookie.click();
        Thread.sleep(2000);
        buttonAccount.click();
        buttonExit.click();
        logger.info("Close page #1 for ask");

        logger.info("Open page #2 for ask");
        buttonLog.click();
        inputUsername.sendKeys(USERNAME2);
        inputPassword.sendKeys(PASSWORD2);
        buttonSubmit.click();

//        driver.close();
//        steps.initBrowser();
//        steps.loginAskFm(USERNAME2, PASSWORD2);

        buttonNotifications.click();
        buttonAnswerQuestion.click();
        List<String> questionAnswered = new ArrayList<String>();
        questionAnswered.add(HOW_DO_YOU_DO);
        questionAnswered.add(lastQuestion.getText());
        return questionAnswered;
    }
}
