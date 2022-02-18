package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class RadioButton {

    String id;

    public RadioButton(String id){
        this.id = id;
    }


    public void click(){
        log.info("Click to radio button");
        $(id).setSelected(true);
    }

    public String read(){
        return $(By.id(id)).getValue();
    }
}
