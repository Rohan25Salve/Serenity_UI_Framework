package OrangeHrm.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    public static final Target USER_PROFILE = Target.the("Click on USer  Profile").located(By.cssSelector("i.oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon"));
    public static final Target CLICK_ON_LOGOUT_BUTTON = Target.the("Click on Logout Button").located(By.xpath("//a[text()='Logout']"));

}
