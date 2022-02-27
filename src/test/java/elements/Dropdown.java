package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;



@Log4j2
public class Dropdown {
    String id;
    String optionLocator = "//select[@id='%s']/option[contains(text(), '%s')]";

    public Dropdown(String id){
        this.id = id;
    }

    public void selectOption(String option){
        log.info(String.format("Select option '%s' into dropdown with id: '%s'%n", option, this.id));
        $(id).selectOptionContainingText(option);

    }

    public String getOption(){
        return $(id).getSelectedText();
    }
}
