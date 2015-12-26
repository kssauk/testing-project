package pages;

//import org.apache.xpath.operations.String;
import org.openqa.selenium.WebDriver;

/**
 * Created by PC on 20.12.2015.
 */
public abstract class AbstractPage {
    protected WebDriver driver;

    public abstract void openPage();

    public AbstractPage (WebDriver driver){
        this.driver = driver;
    }


}
