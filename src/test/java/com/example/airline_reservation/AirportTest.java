package com.example.airline_reservation;

import com.example.airline_reservation.Model.Address;
import com.example.airline_reservation.Model.Airport;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

@SpringBootTest
class AirportTest {

    @BeforeClass
    public static void setup(){
        RestAssured.port=Integer.valueOf(8015);
        RestAssured.baseURI="http://localhost";
        RestAssured.basePath="";
    }

    @Test
    void testGetByCode() {
        Airport airport=new Airport("IWA","IOWA",new Address("1000","fairField","iowa","52257"));
      given()
              .contentType("application/json")
              .body(airport)
              .when().post("/airports").then()
              .statusCode(200);
        given()
                .when()
                .get("/airports/IWA")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("code",equalTo("IWA"))
                .body("name",equalTo("IOWA"))
                .body("street",equalTo("1000"))
                .body("city",equalTo("fairField"))
                .body("state",equalTo("iowa"))
                .body("zip",equalTo("52257"));
        given()
                .when()
                .delete("airports/IWA");
    }
    @Test
    public void testDeleteAirports(){
           Airport airport=new Airport("CHI","CHICAGO",new Address("1000","fairField","iowa","52257"));
      given()
              .contentType("application/json")
              .body(airport)
              .when().post("/airports").then()
              .statusCode(200);
      given()
              .when()
              .delete("airports/CHI");
      given()
              .when()
              .get("airports/CHI")
              .then()
              .statusCode(404)
              .and()
              .body("errorMessage",equalTo("Contact with Code= CHI is not available"));
       }
       @Test
    public void testUpdateAirports(){
           Airport airport=new Airport("IWA","IOWA",new Address("1000","fairField","iowa","52257"));
           Airport airportUpdate=new Airport("IWA","FairField",new Address("1000","fairField","iowa","52257"));
           given()
                   .contentType("application/json")
                   .body(airportUpdate)
                   .when().post("/airports")
                   .then()
                   .statusCode(200);
           given()
                   .when()
                   .get("/airports/IWA")
                   .then()
                   .statusCode(200)
                   .and()
                   .body("code",equalTo("IWA"))
                   .body("name",equalTo("FairField"))
                   .body("street",equalTo("1000"))
                   .body("city",equalTo("fairField"))
                   .body("state",equalTo("iowa"))
                   .body("zip",equalTo("52257"));
           given()
                   .when()
                   .delete("airports/IWA");


}
    @Test
    public void testGetAllContacts() {
        // add the contacts
        Airport airport=new Airport("IWA","IOWA",new Address("1000","fairField","iowa","52257"));
        Airport airport1=new Airport("MMA","FairField",new Address("100","fairField","IOWA","5225"));
        given()
                .contentType("application/json")
                .body(airport)
                .when().
                post("/airports")
                .then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(airport1)
                .when().post("/airports").then()
                .statusCode(200);

        // get all contacts and verify
        given()
                .when()
                .get("/airports")
                .then()
                .statusCode(200)
                .and()
                .body("airports.code", hasItems("IWA", "MMA"))
                .body("airports.name",hasItems("IOWA", "FairField"))
                .body("airports.street",hasItems("1000", "100"))
                .body("airports.city",hasItems("fairField", "fairField"))
                .body("airports.state",hasItems("iowa", "IOWA"))
                .body("airports.zip",hasItems("52257", "5225"));
        //cleanup
        given()
                .when()
                .delete("airports/IWA");
        given()
                .when()
                .delete("airports/MMA");
    }
}

