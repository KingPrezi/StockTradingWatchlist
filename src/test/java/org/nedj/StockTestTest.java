package org.nedj;

import stock.nedj.Controller.StockController;
import stock.nedj.Services.StockService;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static com.jayway.restassured.RestAssured.given;


@RunWith(SpringRunner.class)
@WebMvcTest(value = StockController.class,secure = false)
public class  StockTestTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private StockService stockService;



    @BeforeClass
    public static void setup() throws IOException {

      /*  String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/stock/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;*/


    }

    @After
    public void verify() throws Exception {

    }

    @Test
    public void testGetStockBySymbolOk() throws Exception {

        String symbol = "a";
       HttpUriRequest request = new HttpGet("https://api.iextrading.com/1.0/stock/" + symbol + "/quote");

        //When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        //then
        assertThat(httpResponse.getStatusLine().getStatusCode(),equalTo(HttpStatus.SC_OK));

    }


    @Test
    public void testGetStockBySymbolNotFound() throws Exception{

        String symbol = "kdifqfksd";
        HttpUriRequest request = new HttpGet("https://api.iextrading.com/1.0/stock/" + symbol + "/quote");

        //When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        //Then
        assertThat(httpResponse.getStatusLine().getStatusCode(),equalTo(HttpStatus.SC_NOT_FOUND));

  }

  @Test
    public void makeSureApiIsUp() {
        given().when().get("https://api.iextrading.com/1.0/ref-data/symbols").then().statusCode(200);
  }

 /* @Test
    public void dataPost(){
        Stock stock = new Stock();
        stock.setName("Simon");
        stock.setSymbol("a");
        stock.setChangePercent("24");
        stock.setChanges("223");

        given().contentType("application/json").body(stock)
                .when().post("stock/watchstock").then()
                .body("empty",equalTo(false));
  }
*/



}