package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Input {

    //String inputLocator = "//div//input[(@type='text') and (@id='%s')]";
    //String inputLocator = "//div//input[(@type='text') and (@id='WorkoutTime')]"
    String id;

    public Input(String id){
        this.id = id;
    }

    public void write(String text){

        $(id).clear();
        $(id).sendKeys(text);
    }

    public String read(){
        return $(id).getValue();
    }
}
