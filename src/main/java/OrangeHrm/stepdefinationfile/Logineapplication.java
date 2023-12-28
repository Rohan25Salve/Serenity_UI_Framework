package OrangeHrm.stepdefinationfile;

import OrangeHrm.pageaction.HomePageAction;
import OrangeHrm.pageaction.LoginePageAction;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.core.Serenity.getDriver;

public class Logineapplication {


    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage(Scenario scenario){
        OnStage.setTheStage(new OnlineCast());

    }





    @After
    public void drawTheCurtain() {
        OnStage.drawTheCurtain();
    }

    @AfterStep
    public void takeScreenshotForEachStep( Scenario scenario) {
        scenario.attach(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName().trim());

    }

    @When("{actor} logs out the application")
    public void userLogsOutTheApplication(Actor actor) {
        actor.attemptsTo(
                HomePageAction.logOut());
    }



    @Given("{actor} logged into Orange application as {string} profile user")
    public void userLoggedIntoOrangeApplicationAsProfileUser(Actor actor,String role) {
        actor.attemptsTo(
                LoginePageAction.openBrowser(),
                LoginePageAction.loggdIn(role)
        );
    }
}
