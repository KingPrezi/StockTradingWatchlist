package stock.nedj.Services;

import java.io.FileNotFoundException;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import stock.nedj.Exceptions.DataNotFoundException;
import stock.nedj.Model.Response;
import stock.nedj.Model.Stock;
import stock.nedj.Model.StockResponse;
import stock.nedj.Repositories.StockRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    ///////////////////////////////URL connection method
    public StockResponse urlConnec(String symbol, String name) {

        StockResponse stockPersist = new StockResponse("Found symbol ");
        ObjectMapper objectMapper = new ObjectMapper();


        try{

            URL url = new URL("https://api.iextrading.com/1.0/stock/" + symbol + "/quote?" +
                    "filter=symbol,companyName,sector,open,close,high,low,latestPrice,latestTime,delayedPrice,extendedPrice,lastVolume,change," +
                    "changePercent,peRatio,marketCap");

            stockPersist.setStock(objectMapper.readValue(url, Stock.class));

            stockPersist.getStock().setName(name);




        }catch (FileNotFoundException fi){
            return new StockResponse("Not found");
        } catch (UnknownHostException b){
            return  new StockResponse("You are not connected to the internet");
        }catch (Exception e){
            e.printStackTrace();
        }

        return stockPersist;
    }

    /////////////////get data from API based on Symbol provided
    public StockResponse getStock(String symbol, String name) {

        return this.urlConnec(symbol,name);

    }

    /////////////// get stock from API based on Url and post to database along with username
    public StockResponse watchStock(String symbol, String name) {


       Stock stock = this.urlConnec(symbol, name).getStock();

       if(stock != null){

           this.stockRepository.save(stock);
       }


       return this.urlConnec(symbol, name);
    }

    ////////////////////////Return all Stocks that are in the database
    public Response getStocks(String name) {

        Response stoc = new Response("Found symbol ");

        
           return stockRepository.findByName(name);
        

    }
}

