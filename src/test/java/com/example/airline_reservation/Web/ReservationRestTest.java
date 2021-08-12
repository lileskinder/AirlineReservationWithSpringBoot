package com.example.airline_reservation.Web;

import com.example.airline_reservation.Model.ReservationStatus;
import com.example.airline_reservation.Service.DTOs.ReservationDTO;
import com.example.airline_reservation.Service.DTOs.TicketDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.minidev.json.JSONArray;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class ReservationRestTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8016);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetReservationByCode() {
        TicketDTO ticketDTO = new TicketDTO(new BigInteger("123"), 41, 1, "r3");
        List<TicketDTO> ticketDTOList = Arrays.asList(ticketDTO);
        ReservationDTO reservationDTO = new ReservationDTO("r3", 43, ticketDTOList, ReservationStatus.PENDING);

//        given()
//                .contentType("application/json")
//                .body(reservationDTO)
//                .when().post("/reservations").then()
//                .statusCode(200);

        given()
            .when()
            .get("reservations/r3")
            .then()
            .contentType(ContentType.JSON)
            .and()
            .body("code",equalTo( "r3"))
            .body("customerId",equalTo(43))
            .body("tickets[0].reservationCode", equalTo("r3"))
            .body("status",equalTo( "PENDING"));
    }

}
