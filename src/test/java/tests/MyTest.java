package tests;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class MyTest {

    //@Test
    public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {

        given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
    }
  //  @Test
    public void test_mrBuggy_checkSize() {
        String name = "dasds";
        Response response =  given().
                when().
                header("Content-Type", "application/x-www-form-urlencoded").
                header("Accept", "application/json").
                header("Authorization", "QWRtaW4=:TXJCdWdneTE5IQ==").
                get("http://localhost:8080/user").
                then().extract().response();

assertThat(response.jsonPath().getList("Data").size(),is(1));

name= response.jsonPath().get().toString();
System.out.println(name);
    }

  //  @Test
    public void test_mrBuggy_checkRole() {
        String name = "dasds";
        Response response =  given().
                when().
                header("Content-Type", "application/x-www-form-urlencoded").
                header("Accept", "application/json").
                header("Authorization", "QWRtaW4=:TXJCdWdneTE5IQ==").
                get("http://localhost:8080/user").
                then().extract().response();



        assertThat(response.jsonPath().get("Data[0].Role"),is("Admin"));


    }

 //   @Test
    public void test_mrBuggy_checkRoleType() {
        String name = "dasds";
        Response response =  given().
                when().
                header("Content-Type", "application/x-www-form-urlencoded").
                header("Accept", "application/json").
                header("Authorization", "QWRtaW4=:TXJCdWdneTE5IQ==").
                get("http://localhost:8080/user").
                then().extract().response();


         name=(response.jsonPath().get("Data[0].Role"));

    }

 //   @Test
    public void test_mrBuggy_checkSchema() {
        String name = "dasds";
        given().
                when().
                header("Content-Type", "application/x-www-form-urlencoded").
                header("Accept", "application/json").
                header("Authorization", "QWRtaW4=:TXJCdWdneTE5IQ==").
                get("http://localhost:8080/user").
                then().assertThat().body(matchesJsonSchemaInClasspath("JsonSchemaFile.json"));




    }

   // @Test
    public void test_ResponseHeaderData_ShouldBeCorrect() {

        given().
                when().
                get("http://ergast.com/api/f1/2017/circuits.json").
                then().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                and().
                header("Content-Length",equalTo("4551"));
    }

   // @Test
    public void test_queryParameters_Md5CheckSumForTest_ShouldBe098f6bcd4621d373cade4e832627b4f6() {

        String originalText = "test";
        String expectedMd5CheckSum = "098f6bcd4621d373cade4e832627b4f6";

        given().
                param("text",originalText).
                when().
                get("http://md5.jsontest.com").
                then().
                assertThat().
                body("md5",equalTo(expectedMd5CheckSum));
    }

  //  @Test
    public void test_NumberOfCircuits_ShouldBe20_Parameterized() {

        String season = "2017";
        int numberOfRaces = 20;

        given().
                pathParam("raceSeason",season).
                when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(numberOfRaces));
    }
}

