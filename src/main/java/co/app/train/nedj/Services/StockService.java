package co.app.train.nedj.Services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
//import org.json.simple.parser.JSONParser;
import co.app.train.nedj.Exceptions.DataNotFoundException;
import co.app.train.nedj.Model.Stock;
import co.app.train.nedj.Repositories.StockRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {


    }



    public String getStock(String symbol) throws IOException {

        String dataL = "";

        String url = "https://api.iextrading.com/1.0/stock/" + symbol + "/quote?filter=symbol,companyName,sector,open,close,high,low,latestPrice,iexVolume,latestTime,delayedPrice,extendedPrice,lastVolume,change,changePercent,peRatio,marketCap,week52High,week52Low";
        try{
            URL obj = new URL(url);

            URLConnection yc = obj.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine;


            inputLine = in.readLine();
            dataL = inputLine;
        } catch(MalformedURLException e){
            e.getStackTrace();
        } catch (DataNotFoundException dnfe){

            dataL = "Stock with symbol " + symbol + " not found";
        } catch (FileNotFoundException f){

            dataL = "Stock with symbol " + symbol + " not found";
        } catch(Exception e){
            e.printStackTrace();
        }


        return dataL;


    }


    public Stock watchStock(String symbol, String name) throws Exception {



        ObjectMapper objectMapper = new ObjectMapper();

        URL url = new URL("https://api.iextrading.com/1.0/stock/" + symbol +"/quote?filter=symbol,companyName,sector,open,close,high,low,latestPrice,latestTime,delayedPrice,extendedPrice,lastVolume,change,changePercent,peRatio,marketCap");



        Stock stockPersist = objectMapper.readValue(url, Stock.class);
        stockPersist.setName(name);



        if(stockPersist == null){

            throw new Exception("No data found");
        }


        this.stockRepository.save(stockPersist);

        return stockPersist;

    }


    public List<Stock> getStocks() {


        return stockRepository.findAll();
    }
}
