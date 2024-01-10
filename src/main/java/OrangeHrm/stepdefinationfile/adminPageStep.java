package OrangeHrm.stepdefinationfile;

import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.Actor;
import static OrangeHrm.pageaction.adminPageAction.userclickonsideBar;

public class adminPageStep {

    @And("{actor} Click on {string} Side bar tab")
    public void userclickonsidebar(Actor actor,String sidebar) {
        actor.attemptsTo(
                userclickonsideBar(sidebar)
                );
    }

    @And("{actor} Click on {string}  tab")
    public void userclickontab(Actor actor,String tab) {
        actor.attemptsTo(
                userclickonsideBar(tab)
        );
    }

}
