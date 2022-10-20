package tests.api;

import classes.Reqres;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import models.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import specifications.Specifications;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@Tags({@Tag("API"), @Tag("GET")})
@Owner("berezinaa")
@Feature("Work with reqres user lists")
@DisplayName("Test user lists")
public class UserListTest {
    @Test
    @DisplayName("List of Users is not Empty")
    void listOfUsersNotEmptyTest() throws IOException {
        Specifications.setUpSpec(Specifications.reqSpec(), Specifications.resSpec(200));
        AtomicReference<List<User>> userList = new AtomicReference<>();

        step("Given a list of users from site", () ->
                userList.set(
                        given()
                                .when()
                                .get(Reqres.users, 2)
                                .then().log().all()
                                .extract().body().jsonPath().getList("data", User.class)));

        step("Check what user list is not empty", () ->
                assertFalse(userList.get().isEmpty()));
    }

    @Test
    @DisplayName("Check size of User List")
    void checkSizeOfUserListTest() throws IOException {
        Specifications.setUpSpec(Specifications.reqSpec(), Specifications.resSpec(200));
        AtomicReference<List<User>> userList = new AtomicReference<>();

        step("Given a list of users from site", () -> userList.set(
                given()
                        .when()
                        .get(Reqres.users, 2)
                        .then().log().all()
                        .extract().body().jsonPath().getList("data", User.class)));

        step("Check what user list is not empty", () ->
                assertEquals(6, userList.get().size()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Funke"})
    @DisplayName("Check last name of Tobias")
    void checkLastNameTest(String expectedLastName) throws IOException {
        Specifications.setUpSpec(Specifications.reqSpec(), Specifications.resSpec(200));
        AtomicReference<String> actualLastName = new AtomicReference<>();

        step("Get lastname of Tobias", () ->
                actualLastName.set(
                        given()
                                .when()
                                .get(Reqres.users, 2)
                                .then().log().all()
                                .extract().body().jsonPath().getList("data", User.class)
                                .stream().filter(user -> user.getFirstName().equals("Tobias"))
                                .findFirst().get().getLastName()));

        step("Check actual last name", () ->
                assertEquals(expectedLastName, actualLastName.get()));
    }
}
