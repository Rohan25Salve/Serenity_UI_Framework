package OrangeHrm.helper;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomDriver implements DriverSource {
    @Override
    public WebDriver newDriver() {

       try {
           System.setProperty("webdriver.chrome.driver", "C:/Users/admin/IdeaProjects/OrangeHr_UI_Automation/src/main/resources/drivers/chromedriver.exe");
           WebDriver driver = new ChromeDriver();
           driver.manage().window().maximize();
           return driver;
       }catch (Exception e){

           throw new Error(e);
       }
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }


    public  boolean retu() {
        return false;
    }
}
