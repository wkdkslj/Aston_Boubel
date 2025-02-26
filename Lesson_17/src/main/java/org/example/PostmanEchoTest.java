package org.example;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

    public class PostmanEchoTest {
        static {
            RestAssured.baseURI = "https://postman-echo.com";
        }
        @Test public void testGetRequestStatus200() {
            given()
                    .when()
                    .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2")
                    .then()
                    .assertThat()
                    .statusCode(200);
        }

        @Test public void testGetResponseTime5000status200() {
            long responseTime =
                    given()
                            .when()
                            .get("https://postman-echo.com")
                            .time();

            assert(responseTime<5000);
        }

        @Test
        public void testGetRequest200() {
            given()
                    .when()
                    .get("/get?foo1=bar1&foo2=bar2")
                    .then()
                    .statusCode(200)
                    .body("args.foo1", equalTo("bar1"));
        }

        @Test
        public void testPostRequest200() {
            given()
                    .when()
                    .header("Content-Type", "application/json")
                    .body("{\"foo1\":\"bar2\"}")
                    .post("/post")
                    .then()
                    .assertThat()
                    .statusCode(200);
        }

        @Test
        public void testPostMultiPart200() {
            given()
                    .multiPart("cat1", "meow1")
                    .multiPart("dog2", "bark2")
                    .when()
                    .post("/post")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body("form.cat1", equalTo("meow1"))
                    .body("form.dog2", equalTo("bark2"));
        }

        @Test
        public void testPutRequest200() {
            given()
                    .header("Content-Type", "application/json")
                    .body("{\"meow\":\"kitik\"}")
                    .when()
                    .put("/put")
                    .then()
                    .statusCode(200)
                    .body("json.meow", equalTo("kitik"));
        }
        @Test
        public void testPatchRequest200() {
            given()
                    .header("Content-Type", "application/json")
                    .body("{\"key\":\"updatedValue\"}")
                    .when()
                    .patch("/patch")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body("json.key", equalTo("updatedValue"));
        }
        @Test
        public void test_post_request_by_id_200() {
            String requestBody = "{\"key\":\"value\"}";

            given()
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .when()
                    .post("/post/")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .body("json.key", equalTo("value"));
        }
        @Test
        public void test_delete_request_200() {

            given()
                    .when()
                    .delete("/delete")
                    .then()
                    .assertThat()
                    .statusCode(200);
        }
    }
