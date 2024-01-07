package OrangeHrm.stepdefinationfile;

import OrangeHrm.pageaction.DashbardPageAction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.Actor;

public class Dashboard {

    @And("{actor} click on Profile button")
    public  void clickonProfile(Actor actor){
        actor.attemptsTo(
                DashbardPageAction.ClcikonProfile());

    }



    @And("{actor} Click on About Button and verify description")
    public void verifyabout(Actor actor, DataTable dataTable){

        actor.attemptsTo(
                DashbardPageAction.verifyabout(dataTable)
        );
    }


    @And("{actor} click on Support and Verify email {string} and Header {string}")
    public void verifysupport(String email, String header, Actor actor){


        actor.attemptsTo(
                DashbardPageAction.Verifysupporttag(email,header)

        );
    }




}
