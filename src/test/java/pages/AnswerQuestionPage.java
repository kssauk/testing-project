package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 21.12.2015.
 */
public class AnswerQuestionPage extends AbstractPage{

    private final String BASE_URL = "https://ask.fm/login";
    private final Logger logger = Logger.getLogger(AnswerQuestionPage.class);
    private static final String I_AM_FINE = "I am fine";
    private final String USERNAME1 = "TestingProject";
    private final String PASSWORD1 = "testing123";
    private final String USERNAME2 = "TestingProject2";
    private final String PASSWORD2 = "testing123";

    public AnswerQuestionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    @FindBy(xpath = "//a[@href='/account/notifications']")
    private WebElement buttonNotifications;

    @FindBy(xpath = "//div[@class='item streamItem streamItem-notification']")
    private WebElement buttonAnswerQuestion;

    @FindBy(xpath = "//form[@id='answerForm']//div[@class='answer']//textarea[@id='question_answer_text']")
    private WebElement inputText;

    @FindBy(xpath = "//div[@class='optionsBar']//input[@type='submit']")
    private WebElement buttonAnswer;

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

    @FindBy(xpath = "//nav[@class='subTabBar']//a[@href='/account/notifications/answers']")
    private WebElement buttonUsersAnswers;

    @FindBy(xpath = "//div[@class='item streamItem streamItem-notification']//a[@class='streamItemAvatar icon-answer']")
    private WebElement buttonAnsweredQuestion;

    @FindBy(xpath = "//p[@class='streamItemContent streamItemContent-answer']")
    private WebElement textAnsweredText;

    @FindBy(xpath = "//a[@href='/TestingProject2']")
    private WebElement buttonProfile;

    @FindBy(xpath = "//a[@data-action='AnswerDelete']")
    private WebElement buttonDeleteAnswer;

    @FindBy(xpath = "//a[@data-action='CookieNoticeAccept']")
    private WebElement buttonCloseCookie;



    public List<String> answerNewQuestion () throws InterruptedException {
        //String answerFullText = Utils.getRandomString(7);

        buttonNotifications.click();
        logger.info("Answered page opened");
        Thread.sleep(2000);
        buttonAnswerQuestion.click();
        Thread.sleep(2000);
        inputText.sendKeys(I_AM_FINE);
        Thread.sleep(2000);
        buttonAnswer.click();

        Thread.sleep(2000);
        buttonSettings.click();
        buttonSettings.click();
        Thread.sleep(2000);
        buttonCloseCookie.click();
        Thread.sleep(2000);
        buttonAccount.click();
        buttonExit.click();
        logger.info("Close page #1 for answer");

        logger.info("Open page #2 for answer");
        buttonLog.click();
        inputUsername.sendKeys(USERNAME1);
        inputPassword.sendKeys(PASSWORD1);
        buttonSubmit.click();

        buttonNotifications.click();
        Thread.sleep(2000);
        buttonUsersAnswers.click();
        Thread.sleep(2000);
        buttonAnsweredQuestion.click();

        List<String> newAnswer = new ArrayList<String>();
        newAnswer.add(I_AM_FINE);
        newAnswer.add(textAnsweredText.getText());
        return newAnswer;
        //textAnsweredText.getText();
    }

    public void deleteQuestion() throws InterruptedException {

        Thread.sleep(2000);
        buttonSettings.click();
        buttonSettings.click();
        Thread.sleep(2000);
        buttonAccount.click();
        buttonExit.click();
        logger.info("Close page #2 to delete answer");

        logger.info("Open page #2 to delete answer");
        buttonLog.click();
        inputUsername.sendKeys(USERNAME2);
        inputPassword.sendKeys(PASSWORD2);
        buttonSubmit.click();
        buttonProfile.click();
        buttonDeleteAnswer.click();
    }
}
