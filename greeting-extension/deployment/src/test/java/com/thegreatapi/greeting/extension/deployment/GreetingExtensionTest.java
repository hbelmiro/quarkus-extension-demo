package com.thegreatapi.greeting.extension.deployment;

import io.quarkus.test.QuarkusUnitTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.hamcrest.Matchers.containsString;

class GreetingExtensionTest {

    @RegisterExtension
    static final QuarkusUnitTest config = new QuarkusUnitTest().withEmptyApplication();

    @Test
    void testGreeting() {
        RestAssured.when()
                .get("/greeting")
                .then()
                .statusCode(200)
                .body(containsString("Hello"));
    }

}