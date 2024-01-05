package OrangeHrm.pageaction;


import OrangeHrm.pageobject.HomePage;
import OrangeHrm.task.WaitUtils;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class HomePageAction {

    private HomePageAction(){}

    public static Performable logOut(){
       return Task.where("logged out",
               JavaScriptClick.on(HomePage.USER_PROFILE),
               WaitUntil.the(HomePage.CLICK_ON_LOGOUT_BUTTON,isVisible()).forNoMoreThan(100).seconds(),
               JavaScriptClick.on(HomePage.CLICK_ON_LOGOUT_BUTTON),
               WaitUtils.sleep(3)
               );

    }
}
