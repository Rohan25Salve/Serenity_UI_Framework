package OrangeHrm.task;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@Slf4j
public class KeyUtils implements Performable {
    private final Keys Key;

    public KeyUtils(Keys key) {Key = key;
    }

    @Override
    public <T extends Actor> void performAs(T t) {
        try {
            log.info("Pressing Key" + Key);
            new Actions(Serenity.getDriver()).sendKeys(Key).build().perform();
        }catch (Exception e){
            log.info("Problem in pressing Key" + Key);
        }

    }

   public static Performable keyPress(Keys key){return instrumented(KeyUtils.class);}
}
