package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class WHMainPage {
    private final SelenideElement pageHeader = $x("//span[@class = 'page_header_span' ]");

    public String getHeaderText(){
        return pageHeader.text();
    }
}
