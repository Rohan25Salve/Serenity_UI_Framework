package OrangeHrm.pageobject;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class myInfoPage {

    public static final Target SEARCH_BAR = Target.the("Search bar").located(By.cssSelector("div[class*='body'] input"));
    public static final Target FIRST_SEARCH_RESULT = Target.the("First Search result").located(By.cssSelector("div[class*='body']  ul a span"));






}
