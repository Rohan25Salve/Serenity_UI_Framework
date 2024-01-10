package OrangeHrm.pageaction;

import OrangeHrm.helper.PageContants;
import OrangeHrm.pageobject.LoginPage;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginePageAction {

    private LoginePageAction(){}

    private static String getPage(){return PageContants.LOGIN_PAGE;}

    public static Performable openBrowser(){
        return Task.where("Open the Login Page", Open.browserOn().the(LoginPage.class));
    }

    public static Performable loggdIn(String role){

        String username = AbstractPageAction.getTestData(getPage() + ":" + role,"username");
        String password = AbstractPageAction.getTestData(getPage() + ":" + role,"password");

        return Task.where("Logine Application",
                WaitUntil.the(LoginPage.USERNAME,isVisible()).forNoMoreThan(100).seconds(),
                Enter.theValue(username).into(LoginPage.USERNAME),
                Enter.theValue(password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.CLICK_ON_LOGIN_BUTTON)

        );



    }
}
