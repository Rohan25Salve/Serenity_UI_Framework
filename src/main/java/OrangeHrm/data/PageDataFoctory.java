package OrangeHrm.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageDataFoctory {

    private Map<String ,PageData> pageSteps;

    public PageData getPage(String PageName){

        return Optional.ofNullable(pageSteps.get(PageName)).orElseThrow(() -> new RuntimeException(("Page" + PageName +"is not found in the Page Data Factory")));
    }
}
