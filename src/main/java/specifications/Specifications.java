package specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Specifications {
    private final static String PROPERTIES_PATH ="src/test/resources/application.properties";

    public static RequestSpecification reqSpec(String url){
        return new RequestSpecBuilder()
                .setBasePath(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification resSpec(int statusCode){
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }

    public static void setUpSpec(RequestSpecification reqSpec, ResponseSpecification resSpec) throws IOException {
        final Properties properties = new Properties();
        properties.load(new FileInputStream(PROPERTIES_PATH));
        String URI = properties.getProperty("baseUri");
        RestAssured.requestSpecification = reqSpec.baseUri(URI);
        RestAssured.responseSpecification = resSpec;
    }
}
