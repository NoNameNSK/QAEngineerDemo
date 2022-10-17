package tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import models.User;
import specifications.Specifications;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Tags({@Tag("API"), @Tag("GET")})
@Owner("berezinaa")
@Feature("Work with reqres user lists")
@DisplayName("Test user lists")
public class UserListTest {
    private final static String URL = "/api/users?page=2";

    @Test
    @DisplayName("List of Users is not Empty")
    void listOfUsersNotEmptyTest() throws IOException {
        Specifications.setUpSpec(Specifications.reqSpec(URL), Specifications.resSpec(200));
        AtomicReference<List<User>> userList = new AtomicReference<>();

        step("Given a list of users from site", () -> userList.set(given()
                .when()
                .get()
                .then().log().all()
                .extract().body().jsonPath().getList("data", User.class)));

        step("Check what user list is not empty", () -> {
            assertFalse(userList.get().isEmpty());
        });
    }
}
