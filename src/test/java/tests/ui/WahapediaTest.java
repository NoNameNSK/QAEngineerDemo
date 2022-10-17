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

        Assert.assertEquals(mainPageHeaderText, new WHGameChoosePage(BASE_URL)
                .chooseWHGame()
                .getHeaderText());
    }
}
