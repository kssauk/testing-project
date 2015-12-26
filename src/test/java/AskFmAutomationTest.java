//package java;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AnswerQuestionPage;
import pages.AskQuestionPage;
import steps.Steps;

import java.util.List;


/**
 * Created by PC on 19.12.2015.
 */
public class AskFmAutomationTest {

    private Steps steps;
    private final String USERNAME1 = "TestingProject";
    private final String PASSWORD1 = "testing123";
    private final String USERNAME2 = "TestingProject2";
    private final String PASSWORD2 = "testing123";

    @BeforeMethod(description = "Init browser")
    public void setUp(){
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description="Login to Ask.fm")
    public void oneCanLoginAskFm(){
        steps.loginAskFm(USERNAME1, PASSWORD1);
        Assert.assertTrue(steps.isLoggedIn(USERNAME1));
    }

    @Test(description="Answer a question")
    public void oneCanQuestionAnswering() throws InterruptedException {
        steps.loginAskFm(USERNAME2, PASSWORD2);
        List<String> answer = steps.newAnswer();
        Assert.assertEquals(answer.get(0),answer.get(1));
        steps.deleteNewQuestion();
    }

    @Test(description="Ask a question")
    public void oneCanAskingQuestion() throws InterruptedException {
        steps.loginAskFm(USERNAME1, PASSWORD1);
        List<String> questionAndAnswer = steps.newQuestion();
        Assert.assertEquals(questionAndAnswer.get(0),questionAndAnswer.get(1));
    }



//    @Test(description="Add new location")
//    public void oneCanAddNewLocation(){
//        steps.loginAskFm(USERNAME1, PASSWORD1);
//        List<String> location = steps.newLocation();
//        Assert.assertEquals(location.get(0),location.get(1));
//    }

    @Test(description="Find a friend")
    public void oneCanFindAFriend() throws InterruptedException {
        steps.loginAskFm(USERNAME1, PASSWORD1);
        List<String> friend = steps.serchFriend();
        Assert.assertEquals(friend.get(0),friend.get(1));
    }

    @Test(description="Find new friend")
    public void oneCanFindANewFriend() throws InterruptedException {
        steps.loginAskFm(USERNAME1, PASSWORD1);
        List<String> friend = steps.addToListNewFriend();
        Assert.assertEquals(friend.get(0),friend.get(1));
        steps.deleteNewFriend();
    }


    @AfterMethod(description="Stop Browsser")
    public void stopBrowser(){
        steps.closeDriver();
    }


}
