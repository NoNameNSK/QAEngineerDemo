package tests.selenoid;

import base.SelenoidExtension;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Tags({@Tag("UI")})
@Owner("berezinaa")
@Feature("Test some Web resource")
@DisplayName("Wahapedia UI tests")
@ExtendWith(SelenoidExtension.class)
public class WahapediaTest extends tests.ui.WahapediaTest {
    @Override
    @Test
    public void checkMainPageText() {
        super.checkMainPageText();
    }
}
