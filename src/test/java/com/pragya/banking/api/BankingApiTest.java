package com.pragya.banking.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BankingApiTest {

    @Test
    public void verifyParaBankApi() {

        Response response =
                RestAssured.get(
                    "https://parabank.parasoft.com/parabank/services/bank/customers/12212"
                );

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body:");
        System.out.println(response.asPrettyString());

        Assert.assertEquals(
                response.getStatusCode(),
                200,
                "API status code is not 200"
        );
        
     // Validate response body
        Assert.assertTrue(
                response.asString().contains("<customer>"),
                "Customer data not found in response"
        );

        // Validate Content-Type
        Assert.assertTrue(
                response.getContentType().contains("xml"),
                "Response Content-Type is not XML"
        );

        // Validate response time
        long responseTime = response.getTime();

        System.out.println("Response Time: " + responseTime + " ms");
        System.out.println("Content Type: " + response.getContentType());

        Assert.assertTrue(
                responseTime < 10000,
                "API response took more than 10 seconds. Actual: " + responseTime + " ms"
        );

        System.out.println("Response Time: " + response.getTime() + " ms");
        System.out.println("Content Type: " + response.getContentType());
    }   
        @Test
        public void verifyInvalidCustomerApi() {

            Response response =
                RestAssured
                    .given()
                    .baseUri("https://parabank.parasoft.com")
                    .when()
                    .get("/parabank/services/bank/customers/999999999")
                    .then()
                    .extract()
                    .response();

            System.out.println("Negative API Status: " + response.getStatusCode());
            System.out.println("Negative API Response: " + response.asString());

            Assert.assertEquals(
            	    response.getStatusCode(),
            	    400,
            	    "Invalid customer should return 400"
            	);
            
        }
        
        @Test
        public void verifyFundTransferApi() {

            Response response =
                RestAssured
                    .given()
                    .baseUri("https://parabank.parasoft.com")
                    .queryParam("fromAccountId", 12345)
                    .queryParam("toAccountId", 12456)
                    .queryParam("amount", 10)
                    .when()
                    .post("/parabank/services/bank/transfer")
                    .then()
                    .extract()
                    .response();

            System.out.println("Transfer Status: " + response.getStatusCode());
            System.out.println("Transfer Response: " + response.asString());

            Assert.assertEquals(
                response.getStatusCode(),
                200,
                "Fund transfer API did not return 200"
            );
            
            Assert.assertTrue(
            	    response.asString().contains("Successfully transferred"),
            	    "Transfer success message was not found"
            	);
        }
    }
