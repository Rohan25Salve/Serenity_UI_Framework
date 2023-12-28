package OrangeHrm.task;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@Slf4j
public class WaitUtils implements Performable {

    private final int seconds;

    public WaitUtils(int seconds) {this.seconds = seconds;}

    @Override
    public <T extends Actor> void performAs(T t) {

        try {
            log.info("Sleeping for" + seconds+ "seconds");
            Thread.sleep(seconds * 1_000L);
        } catch (InterruptedException e) {
            log.info("Problem in waiting ...");
            throw new RuntimeException(e);
        }
    }

    public static Performable sleep(int seconds){return instrumented(WaitUtils.class,seconds);}
}