package OrangeHrm.pageaction;

import OrangeHrm.pageobject.LoginPage;
import OrangeHrm.pageobject.myInfoPage;
import OrangeHrm.task.WaitUtils;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.awt.event.PaintEvent;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class myInfoPageAction {

    public static Performable verifysearchsidebar(String tab){
        return Task.where(

                WaitUntil.the(myInfoPage.SEARCH_BAR,isVisible()).forNoMoreThan(100).seconds(),
                Enter.keyValues(tab).into(myInfoPage.SEARCH_BAR),
                WaitUntil.the(myInfoPage.FIRST_SEARCH_RESULT,isVisible()).forNoMoreThan(100).seconds(),
                Ensure.that(myInfoPage.FIRST_SEARCH_RESULT).text().containsIgnoringCase(tab),
                WaitUtils.sleep(2),
                Clear.field(myInfoPage.SEARCH_BAR),
                WaitUtils.sleep(2)
        );


    }
}
