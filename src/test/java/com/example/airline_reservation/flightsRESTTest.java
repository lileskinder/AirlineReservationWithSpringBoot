package com.example.airline_reservation;
//
//import com.example.airline_reservation.DAO.AirlineRepo;
//import com.example.airline_reservation.DAO.AirportRepo;
//import com.example.airline_reservation.DAO.FlightRepo;
//import com.example.airline_reservation.Model.Airline;
//import com.example.airline_reservation.Model.Airport;
//import com.example.airline_reservation.Model.Flight;
//import com.example.airline_reservation.Service.DTOs.DTOAdapters.FlightDTOAdapter;
//import com.example.airline_reservation.Service.DTOs.FlightDTO;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.equalTo;
//
//@RunWith(SpringRunner.class)
////@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class flightsRESTTest {
//
//    @BeforeClass
//    public static void setup() {
//        RestAssured.port = Integer.valueOf(8015);
//        RestAssured.baseURI = "http://localhost";
//        RestAssured.basePath = "";
//    }
//
//
//
//    @Test
//    public void testGetOneFlight() {
////        private int number;
////        private int capacity;
////        private int airlineId;
////        private int departureAirportId;
////        private int arrivalAirportId;
////        private LocalDateTime departureTime;
////        private LocalDateTime arrivalTime;
////        private String flightStatus;
//
////        add a flight to be fetched
////        FlightDTO flightDTO = new FlightDTO(98, 500, 1, 1, 2, LocalDateTime.of(2021, 8, 10, 12, 00), LocalDateTime.of(2021, 8, 11, 12, 00), "Available");
////        Flight flight = FlightDTOAdapter.getFlight(flightDTO, new AirportRepo() {
////            @Override
////            public List<Airport> findAll() {
////                return null;
////            }
////
////            @Override
////            public List<Airport> findAll(Sort sort) {
////                return null;
////            }
////
////            @Override
////            public List<Airport> findAllById(Iterable<Integer> iterable) {
////                return null;
////            }
////
////            @Override
////            public <S extends Airport> List<S> saveAll(Iterable<S> iterable) {
////                return null;
////            }
////
////            @Override
////            public void flush() {
////
////            }
////
////            @Override
////            public <S extends Airport> S saveAndFlush(S s) {
////                return null;
////            }
////
////            @Override
////            public <S extends Airport> List<S> saveAllAndFlush(Iterable<S> iterable) {
////                return null;
////            }
////
////            @Override
////            public void deleteAllInBatch(Iterable<Airport> iterable) {
////
////            }
////
////            @Override
////            public void deleteAllByIdInBatch(Iterable<Integer> iterable) {
////
////            }
////
////            @Override
////            public void deleteAllInBatch() {
////
////            }
////
////            @Override
////            public Airport getOne(Integer integer) {
////                return null;
////            }
////
////            @Override
////            public Airport getById(Integer integer) {
////                return null;
////            }
////
////            @Override
////            public <S extends Airport> List<S> findAll(Example<S> example) {
////                return null;
////            }
////
////            @Override
////            public <S extends Airport> List<S> findAll(Example<S> example, Sort sort) {
////                return null;
////            }
////
////            @Override
////            public Page<Airport> findAll(Pageable pageable) {
////                return null;
////            }
////
////            @Override
////            public <S extends Airport> S save(S s) {
////                return null;
////            }
////
////            @Override
////            public Optional<Airport> findById(Integer integer) {
////                return Optional.empty();
////            }
////
////            @Override
////            public boolean existsById(Integer integer) {
////                return false;
////            }
////
////            @Override
////            public long count() {
////                return 0;
////            }
////
////            @Override
////            public void deleteById(Integer integer) {
////
////            }
////
////            @Override
////            public void delete(Airport airport) {
////
////            }
////
////            @Override
////            public void deleteAllById(Iterable<? extends Integer> iterable) {
////
////            }
////
////            @Override
////            public void deleteAll(Iterable<? extends Airport> iterable) {
////
////            }
////
////            @Override
////            public void deleteAll() {
////
////            }
////
////            @Override
////            public <S extends Airport> Optional<S> findOne(Example<S> example) {
////                return Optional.empty();
////            }
////
////            @Override
////            public <S extends Airport> Page<S> findAll(Example<S> example, Pageable pageable) {
////                return null;
////            }
////
////            @Override
////            public <S extends Airport> long count(Example<S> example) {
////                return 0;
////            }
////
////            @Override
////            public <S extends Airport> boolean exists(Example<S> example) {
////                return false;
////            }
////        },
////                new AirlineRepo() {
////            @Override
////            public List<Airline> findAll() {
////                return null;
////            }
////
////            @Override
////            public List<Airline> findAll(Sort sort) {
////                return null;
////            }
////
////            @Override
////            public List<Airline> findAllById(Iterable<Integer> iterable) {
////                return null;
////            }
////
////            @Override
////            public <S extends Airline> List<S> saveAll(Iterable<S> iterable) {
////                return null;
////            }
////
////            @Override
////            public void flush() {
////
////            }
////
////            @Override
////            public <S extends Airline> S saveAndFlush(S s) {
////                return null;
////            }
////
////            @Override
////            public <S extends Airline> List<S> saveAllAndFlush(Iterable<S> iterable) {
////                return null;
////            }
////
////            @Override
////            public void deleteAllInBatch(Iterable<Airline> iterable) {
////
////            }
////
////            @Override
////            public void deleteAllByIdInBatch(Iterable<Integer> iterable) {
////
////            }
////
////            @Override
////            public void deleteAllInBatch() {
////
////            }
////
////            @Override
////            public Airline getOne(Integer integer) {
////                return null;
////            }
////
////            @Override
////            public Airline getById(Integer integer) {
////                return null;
////            }
////
////            @Override
////            public <S extends Airline> List<S> findAll(Example<S> example) {
////                return null;
////            }
////
////            @Override
////            public <S extends Airline> List<S> findAll(Example<S> example, Sort sort) {
////                return null;
////            }
////
////            @Override
////            public Page<Airline> findAll(Pageable pageable) {
////                return null;
////            }
////
////            @Override
////            public <S extends Airline> S save(S s) {
////                return null;
////            }
////
////            @Override
////            public Optional<Airline> findById(Integer integer) {
////                return Optional.empty();
////            }
////
////            @Override
////            public boolean existsById(Integer integer) {
////                return false;
////            }
////
////            @Override
////            public long count() {
////                return 0;
////            }
////
////            @Override
////            public void deleteById(Integer integer) {
////
////            }
////
////            @Override
////            public void delete(Airline airline) {
////
////            }
////
////            @Override
////            public void deleteAllById(Iterable<? extends Integer> iterable) {
////
////            }
////
////            @Override
////            public void deleteAll(Iterable<? extends Airline> iterable) {
////
////            }
////
////            @Override
////            public void deleteAll() {
////
////            }
////
////            @Override
////            public <S extends Airline> Optional<S> findOne(Example<S> example) {
////                return Optional.empty();
////            }
////
////            @Override
////            public <S extends Airline> Page<S> findAll(Example<S> example, Pageable pageable) {
////                return null;
////            }
////
////            @Override
////            public <S extends Airline> long count(Example<S> example) {
////                return 0;
////            }
////
////            @Override
////            public <S extends Airline> boolean exists(Example<S> example) {
////                return false;
////            }
////        });
//
////        given()
////                .contentType("application/json")
////                .body(flightDTO)
////                .when().post("/flights").then()
////                .statusCode(500);
////
////        // test getting the flight
////        given()
////                .when()
////                .get("flights/98")
////                .then()
////                .contentType(ContentType.JSON)
////                .and()
////                .body("number",equalTo(98))
////                .body("capacity",equalTo(500))
////                .body("airlineId",equalTo(1))
////                .body("departureAirportId",equalTo(1))
////                .body("arrivalAirportId",equalTo(2))
////                .body("departureTime",equalTo( LocalDateTime.of(2021, 8, 10, 12, 00)))
////                .body("arrivalTime",equalTo( LocalDateTime.of(2021, 8, 11, 12, 00)))
////                .body("flightStatus",equalTo("Available"));
////
////        given()
////                .when()
////                .delete("flights/98");
//    }
}
