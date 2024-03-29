package OrangeHrm.stepdefinationfile;

import OrangeHrm.data.ExcelDataLoader;
import OrangeHrm.data.PageDataFoctory;
import OrangeHrm.helper.SessionVariaables;
import OrangeHrm.pageaction.HomePageAction;
import OrangeHrm.pageaction.LoginePageAction;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.core.Serenity.getDriver;
@Slf4j
public class LoginPageStep {

    public static final ThreadLocal<PageDataFoctory> dataFactory = new ThreadLocal<>();
    public static PageDataFoctory getData(){return dataFactory.get();}

    private EnvironmentVariables environmentVariables;

    @Before
    public void setTheStage(Scenario scenario){
        OnStage.setTheStage(new OnlineCast());
        dataFactory.set(ExcelDataLoader.INSTANCE.loadDataFactory(scenario.getName().trim()));

    }

   /* @Before
    public void setTheStage(){
        String webserviceEndPoint = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("webdriver.base.url");
        Serenity.setSessionVariable(SessionVariaables.WEB_SERVICE_END_POINT).to(webserviceEndPoint);
        log.info(webserviceEndPoint);
    }*/




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
        log.info("Application logout");
        actor.attemptsTo(
                HomePageAction.logOut());
    }

    @Given("{actor} logged into Orange application as {string} profile user")
    public void userLoggedIntoOrnageApplicationAsProfileUser(Actor actor,String role) {
        log.info("Application Open as a"+ role );
        actor.wasAbleTo(
                LoginePageAction.openBrowser(),
                LoginePageAction.loggdIn(role)
        );
    }
}
