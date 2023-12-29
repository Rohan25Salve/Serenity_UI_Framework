package OrangeHrm.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
public class LoginPage  extends PageObject {
    public static final Target USERNAME = Target.the("username").located(By.cssSelector("input[name*='username']"));
    public static final Target PASSWORD = Target.the("password").located(By.cssSelector("input[name*='password']"));
    public static final Target CLICK_ON_LOGIN_BUTTON = Target.the("Click on Login Button").located(By.cssSelector("div button"));

}
