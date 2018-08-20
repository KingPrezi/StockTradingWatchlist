package stock.nedj.Services;

import java.io.FileNotFoundException;
import java.net.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(StockService.class);

    ///////////////////////////////URL connection method
    public StockResponse urlConnec(String symbol, String name) {

        StockResponse stockPersist = new StockResponse("Found symbol ");
        ObjectMapper objectMapper = new ObjectMapper();



        try {

            if (name.matches ("^[A-Za-z_-]{3,15}$")) {

            if (symbol.matches("^[A-Za-z_-]{1,6}$")) {

                URL url = new URL("https://api.iextrading.com/1.0/stock/" + symbol + "/quote?" +
                        "filter=symbol,companyName,sector,open,close,high,low,latestPrice,latestTime,delayedPrice,extendedPrice,lastVolume,change," +
                        "changePercent,peRatio,marketCap");

                stockPersist.setStock(objectMapper.readValue(url, Stock.class));

                stockPersist.getStock().setName(name);
            }else {
                return  new StockResponse("Enter a valid symbol");
            }

            }else {
                return  new StockResponse("Enter a valid name");
            }

        } catch (FileNotFoundException fi) {
            return new StockResponse("Not found");
        } catch (UnknownHostException b) {
            return new StockResponse("You are not connected to the internet");
        } catch (Exception e) {
            logger.info(String.format("Symbol %s Name %S", symbol,name));
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
    public Response getStocks(String name){

        Response stoc = new Response(stockRepository.findByName(name),"No stock in the datsbase for the requested name");

    if (stoc.getStock().isEmpty() ) {

        stoc = new Response(stockRepository.findByName(name),"Stock not found");

  }
  else{

        stoc = new Response(stockRepository.findByName(name),"Stock found");

    }

    return stoc;

    }

}