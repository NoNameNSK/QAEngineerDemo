package tests.ui;

import base.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import pages.WHGameChoosePage;

import java.util.concurrent.atomic.AtomicReference;

import static io.qameta.allure.Allure.step;

@Tags({@Tag("UI")})
@Owner("berezinaa")
@Feature("Test some Web resource")
@DisplayName("Wahapedia UI tests")
public class WahapediaTest extends TestBase {
    public final static String BASE_URL = "https://wahapedia.ru/";

    @Test
    @DisplayName("Test game choose")
    public void checkMainPageText(){
        String mainPageHeaderText = "Playing This Game";
        AtomicReference<String> headerText = new AtomicReference<>();

        step("Open web resource, choose game and get header text", () -> {
            headerText.set(new WHGameChoosePage(BASE_URL)
                    .chooseWHGame()
                    .getHeaderText());
        });

        step("Assert what we open right game", () -> Assert.assertEquals(mainPageHeaderText, headerText.get()));

    }
}
