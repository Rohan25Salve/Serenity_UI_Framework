package OrangeHrm.pageobject;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import net.serenitybdd.core.pages.PageObject;

public class LoginPage extends PageObject {
    public static final Target USERNAME = Target.the("username").located(By.cssSelector("input[name*='username']"));
    public static final Target PASSWORD = Target.the("password").located(By.cssSelector("input[name*='password']"));
    public static final Target CLICK_ON_LOGIN_BUTTON = Target.the("Click on Login Button").located(By.cssSelector("div button"));

}
