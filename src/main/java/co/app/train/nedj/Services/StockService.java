package co.app.train.nedj.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
//import org.json.simple.parser.JSONParser;
import co.app.train.nedj.Model.Stock;
import co.app.train.nedj.Repositories.StockRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {

       /* try {
            StockService.findAllStock();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

  /*  public static Object findAllStock() throws  Exception {

       // URL obj = new URL("http://api.iextrading.com/1.0/ref-data/symbols");

        String url = "https://api.iextrading.com/1.0/ref-data/symbols";

        URL obj = new URL(url);

        URLConnection yc = obj.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
       // while ((inputLine = in.readLine()) != null)
         //   System.out.println(inputLine);
      //  in.close();
inputLine = in.readLine();

        //System.out.print(inputLine);

        return inputLine;

    }*/

    public String findStockBySymbol(String symbol) throws IOException {

        symbol = null;

        String url = "https://api.iextrading.com/1.0/stock/" + symbol + "/book";

        URL obj = new URL(url);

        URLConnection yc = obj.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        // while ((inputLine = in.readLine()) != null)
        //   System.out.println(inputLine);
        //  in.close();
        inputLine = in.readLine();

        //System.out.print(inputLine);

        return inputLine;


    }


    public List<Stock> watchStock(String symbol, String name) throws IOException{

        symbol = null;
        name = null;

        ObjectMapper objectMapper = new ObjectMapper();

        String url = "https://api.iextrading.com/1.0/stock/" + symbol +"/quote?filter=symbol,companyName,sector,open,close,high,low,latestPrice,latestTime,delayedPrice,extendedPrice,lastVolume,change,changePercent,peRatio,marketCap/"+ name;

        URL obj = new URL(url);
        List<Stock> stock = new ArrayList<>();

        try {

            stock = objectMapper.readValue(url, new TypeReference<List<Stock>>() {
            });


            URLConnection yc = obj.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine;

            //System.out.print(name);

            inputLine = in.readLine();
        }catch {


        }

        return stockRepository.save(stock);

    }




}
