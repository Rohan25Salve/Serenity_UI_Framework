package OrangeHrm.pageaction;

import OrangeHrm.pageobject.LoginPage;
import OrangeHrm.pageobject.adminPage;
import OrangeHrm.task.WaitUtils;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class adminPageAction {


    public static Performable userclickonsideBar(String tab){
        return Task.where("User Click on Side bar",
                WaitUntil.the(adminPage.selectsidebar(tab),isVisible()).forNoMoreThan(100).seconds(),
                Click.on(adminPage.selectsidebar(tab)),
                WaitUtils.sleep(10)
        );





    }


}
