package OrangeHrm.pageobject;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class adminPage {

    public static final Target selectsidebar(String tab){
        String locator = String.format("//span[text()='%s']",tab);
        return Target.the("click on Side Bar" + tab).locatedBy(locator);
    }

    public static final Target FIRST_ROW_USERNAME = Target.the("Wait for First row Web element").located(By.cssSelector("div[class='orangehrm-container'] div[class*='body'] div:nth-child(1) div div:nth-child(2) div"));

    public static final Target selecttab(String tab){
        String locator = String.format("//div[@class='orangehrm-tabs-wrapper']//child::a[text()='Personal Details']",tab);
        return Target.the("userclickontab" + tab).locatedBy(locator);
    }
}
