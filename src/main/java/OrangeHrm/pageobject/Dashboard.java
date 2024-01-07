package OrangeHrm.pageobject;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Dashboard {

    public static final Target DASHBOARD_SUPPORT = Target.the("Dashboard_Support").located(By.xpath("//a[text()='Support']"));


}
