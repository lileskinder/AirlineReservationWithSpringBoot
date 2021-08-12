package com.example.airline_reservation.Web;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TicketRestTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8016);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetTicketByTicketNumber() {
        given()
            .when()
            .get("tickets/11")
            .then()
            .contentType(ContentType.JSON)
            .and()
            .body("number",equalTo(11))
            .body("flightNumber",equalTo(123))
            .body("passengerName",equalTo("Bayarbat Batbayar"))
            .body("flightNumber",equalTo(123))
            .body("airlineName",equalTo("American Airlines"))
            .body("departureAirportName",equalTo("CHA"))
            .body("arrivalAirportName",equalTo("CHA"))
            .body("departureTime",equalTo("2021-08-10T10:30:00"))
            .body("arrivalTime",equalTo("2021-08-10T10:30:00"))
            .body("flightStatus",equalTo("2"))
            .body("reservationCode",equalTo("r2"))
            .body("reservationStatus",equalTo("PENDING"));
    }
}
