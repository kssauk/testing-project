package steps;

import org.apache.log4j.Logger;
//import org.apache.xpath.operations.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by PC on 20.12.2015.
 */
public class Steps {

    private WebDriver driver;

    private final Logger logger = Logger.getLogger(Steps.class);

    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void loginAskFm(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String username) {

        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getLoggedInUserName().trim().equals('@' + username));
    }

    public void closeDriver() {
        driver.quit();
    }

    public List<String> newQuestion() throws InterruptedException {
        AskQuestionPage askQuestionPage = new AskQuestionPage(driver);
        List<String> questionAndAnswers = askQuestionPage.askNewQuestion();
        return questionAndAnswers;
    }

    public List<String> newAnswer() throws InterruptedException {
        AnswerQuestionPage answerQuestionPage = new AnswerQuestionPage(driver);
        List<String> answers = answerQuestionPage.answerNewQuestion();
        return answers;
    }

    public List<String> newLocation(){
        InformationPage informationPage = new InformationPage(driver);
        List<String> locations = informationPage.addNewInformation();
        return locations;
    }

    public List<String> serchFriend() throws InterruptedException {
        SerchFriendPage serchFriendPage = new SerchFriendPage(driver);
        List<String> friend = serchFriendPage.findFriend();
        return friend;
    }

    public List<String> addToListNewFriend() throws InterruptedException {
        AddNewFriendPage addNewFriendPage = new AddNewFriendPage(driver);
        List<String> newFriend = addNewFriendPage.addNewFriend();
        return newFriend;
    }

    public void deleteNewFriend() throws InterruptedException {
        AddNewFriendPage deleteNewFriend = new AddNewFriendPage(driver);
        deleteNewFriend.unfollowUser();
    }

    public void deleteNewQuestion() throws InterruptedException {

        AnswerQuestionPage deleteNewQuestion = new AnswerQuestionPage(driver);
        deleteNewQuestion.deleteQuestion();
    }

}

