import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostmanEchoTests {
    static {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGet() {
        Response response = given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("---------Get Body:");
        System.out.println(response.getBody().asString());
    }

    @Test
    public void testPost() {

        String jsonBody = "{ \"test\": \"value\" }";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("---------Post Body:");
        System.out.println(response.getBody().asString());
    }

    @Test
    public void testPost2() {

        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("---------Post2 Body:");
        System.out.println(response.getBody().asString());
    }

    @Test
    public void testPut() {

        Response response = given()
                .header("Content-Type", "application/json")
                .body("{}")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("---------Put Body:");
        System.out.println(response.getBody().asString());
    }

    @Test
    public void testPatch() {

        Response response = given()
                .body("{}")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("---------Patch Body:");
        System.out.println(response.getBody().asString());
    }

    @Test
    public void testDelete() {

        Response response = given()
                .body("{}")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("---------Delete Body:");
        System.out.println(response.getBody().asString());
    }
}
