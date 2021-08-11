//package com.example.airline_reservation.Web;
//
//import com.example.airline_reservation.Model.Address;
//import com.example.airline_reservation.Model.Airline;
//import com.example.airline_reservation.Model.Airport;
//import com.example.airline_reservation.Model.Flight;
//import com.example.airline_reservation.Service.DTOs.FlightDTO;
//import com.example.airline_reservation.Service.FlightService;
//import io.restassured.module.mockmvc.RestAssuredMockMvc;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import javax.persistence.Embedded;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@WebMvcTest(FlightController.class)
//class FlightControllerTest {
//
//    @MockBean
//    private FlightService flightService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @BeforeEach
//    void setUp() {
//        RestAssuredMockMvc.mockMvc(mockMvc);
//    }
//
//    @Test
//    void getFlights() {
////        private int id;
////        private String code;
////        private String name;
////        private String history;
//
////        private int id;
////        private String code;
////        private String name;
////
////        private Address address;
//        Airline airline = new Airline(1, "United", "United", "sssss");
//        Airport airport = new Airport("1", "CID", new Address());
//        Flight flight = new Flight(90, 500, airline, airport, airport,
//                LocalDateTime.of(2021, 8, 10, 12, 00),
//                LocalDateTime.of(2021, 8, 11, 12, 00),
//                "Available");
//
//        FlightDTO flightDTO = new FlightDTO(90, 500, 1, 1, 1,
//                LocalDateTime.of(2021, 8, 10, 12, 00),
//                LocalDateTime.of(2021, 8, 11, 12, 00),
//                "Available");
//
//        Mockito.when(flightService.findAll()).thenReturn(
//                List.of(flightDTO)
//        );
//
//        RestAssuredMockMvc
//                .given()
//                .auth().none()
////                .param()
//                .when()
//                .get("/flights")
//                .then()
//                .statusCode(200)
//                .body("$.size()", Matchers.equalTo(1))
//                .body("[0].number", Matchers.equalTo(90))
//                .body("[0].capacity", Matchers.equalTo(500))
//                .body("[0].airlineId", Matchers.equalTo(1))
//                .body("[0].departureAirportId", Matchers.equalTo(1))
//                .body("[0].departureTime", Matchers.equalTo(LocalDateTime.of(2021, 8, 10, 12, 00)))
//                .body("[0].arrivalTime", Matchers.equalTo(LocalDateTime.of(2021, 8, 11, 12, 00)))
//                .body("[0].flightStatus", Matchers.equalTo("Available"));
//
//
//        //        private int number;
////        private int capacity;
////        private int airlineId;
////        private int departureAirportId;
////        private int arrivalAirportId;
////        private LocalDateTime departureTime;
////        private LocalDateTime arrivalTime;
////        private String flightStatus;
//
//    }
//
//}