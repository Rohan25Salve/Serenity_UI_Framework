import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue={"OrangeHrm/stepdefinationfile"},
        plugin ={"pretty",
                "html:target/AtmlReports/report.html",
                "json:target/JsonReports/report.json",
                "junit:target/JunitReports/report.xml"},
        snippets = CAMELCASE,
        features = "src/test/java/OrangeHrm",
        monochrome = true,
        tags="@dashboard_01"

)

public class CucumberTestSuite {}
