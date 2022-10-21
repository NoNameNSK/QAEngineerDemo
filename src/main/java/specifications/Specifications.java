package specifications;

import base.TestBase;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    public static RequestSpecification reqSpec() {
        return new RequestSpecBuilder().setContentType(ContentType.JSON).build();
    }

    public static ResponseSpecification resSpec(int statusCode) {
        return new ResponseSpecBuilder().expectStatusCode(statusCode).build();
    }

    public static void setUpSpec(RequestSpecification reqSpec, ResponseSpecification resSpec) {
        RestAssured.requestSpecification = reqSpec.baseUri(
                TestBase.CONFIG.getString("baseUri"));
        RestAssured.responseSpecification = resSpec;
    }
}
