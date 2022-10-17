package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class WHGameChoosePage {
    private final SelenideElement whGamaButton = $x("//a[contains(@class, \"GameButton1\")]");

    public WHGameChoosePage(String url) {
        openPage(url);
    }

    public WHMainPage chooseWHGame(){
        whGamaButton.click();
        return new WHMainPage();
    }

    public void openPage(String url){
        Selenide.open(url);
    }
}
