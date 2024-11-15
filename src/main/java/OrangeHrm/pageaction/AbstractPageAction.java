package OrangeHrm.pageaction;

import OrangeHrm.data.DataLoaderException;
import OrangeHrm.stepdefinationfile.LoginPageStep;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
@Slf4j
public class AbstractPageAction {
    AbstractPageAction(){}

    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMERIC = "123456789";

    public static String getElementText(Target target) { return Text.of(target).answeredBy(theActorInTheSpotlight()); }
    public static String getRandomString(int length) { return generateRandom(ALPHA.toUpperCase(), length); }
    public static String getRandomNumber(int length) { return generateRandom (NUMERIC, length); }

    private static String generateRandom(String value, int length) {



        StringBuilder sb = new StringBuilder(length);

        try {
            for (int i = 0; i < length ; i++) {
                int rndCharAt = SecureRandom.getInstanceStrong().nextInt(value.length());
                char rndChar = value.charAt(rndCharAt);
                sb.append(rndChar);
            }
        }
        catch (NoSuchAlgorithmException e) {
            log.info("Problem in generating with Random function ()", e.getMessage());
        }

        return sb.toString();
    }

    public static String getCurrentDate(String format, String addDays){

        String stringDate= "";
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        c.setTime(date);
        try{
            c.add(Calendar.DATE,Integer.parseInt(addDays));
            date = c.getTime();
            SimpleDateFormat sdf= new SimpleDateFormat(format);
            stringDate =sdf.format(date);

        }catch (Exception ex){

            log.info("Problem in adding day to current date");
        }

        return stringDate;
    }


    public static String getTestData(String page , String elementKey){
        String value;
        try{
            value = LoginPageStep.getData().getPage(page).getTestData().get(elementKey);
        } catch (Exception e){
            throw new DataLoaderException("Target Key is not Present/matching to get the test data -" + elementKey);
        }

        return Optional.ofNullable(value).orElseThrow(() -> new DataLoaderException("Testdata" + elementKey + "is not found test data Sheet --" + page));

    }

}
