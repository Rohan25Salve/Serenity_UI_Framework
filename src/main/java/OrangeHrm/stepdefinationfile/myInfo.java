package OrangeHrm.stepdefinationfile;

import OrangeHrm.pageaction.myInfoPageAction;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.Actor;

public class myInfo {

    @And("{actor} Validated side Search bar {string}")
    public void verifysearchbar(Actor actor, String tab){
        actor.attemptsTo(
                myInfoPageAction.verifysearchsidebar(tab)
        );

    }
}
