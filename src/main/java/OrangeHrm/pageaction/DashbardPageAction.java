package OrangeHrm.pageaction;

import OrangeHrm.pageobject.HomePage;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;


import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DashbardPageAction {

    public static Performable ClcikonProfile(){
        return Task.where("User Click on Profile Button",
                JavaScriptClick.on(HomePage.USER_PROFILE),
                WaitUntil.the(HomePage.CLICK_ON_LOGOUT_BUTTON,isVisible()).forNoMoreThan(100).seconds()

        );
    }
    public static Performable Verifysupporttag(String email,String header){
        return Task.where("Dashboard_Support",
                WaitUntil.the(HomePage.CLICK_ON_LOGOUT_BUTTON,isVisible()).forNoMoreThan(100).seconds()

        );
    }

    public static Performable verifyabout(DataTable tabel1){
        List<List<String>> data = tabel1.asLists(String.class);

        String compantnameH = data.get(0).get(0);
        String versionH = data.get(0).get(1);
        String activeemployeH = data.get(0).get(2);
        String terminatedH = data.get(0).get(3);

        String compantname = data.get(1).get(0);
        String version = data.get(1).get(1);
        String activeemploye = data.get(1).get(2);
        String terminated = data.get(1).get(3);


        return Task.where("User Click on Profile Button",
                JavaScriptClick.on(HomePage.USER_PROFILE),
                WaitUntil.the(HomePage.CLICK_ON_LOGOUT_BUTTON,isVisible()).forNoMoreThan(100).seconds()

        );
    }


}
