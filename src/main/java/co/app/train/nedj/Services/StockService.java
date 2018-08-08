package co.app.train.nedj.Services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
//import org.json.simple.parser.JSONParser;
import co.app.train.nedj.Exceptions.DataNotFoundException;
import co.app.train.nedj.Model.Stock;
import co.app.train.nedj.Model.StockResponse;
import co.app.train.nedj.Repositories.StockRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class StockService {

    @Autowired
    private StockRepository stockRepository;


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

            dataL = "No data foundl";
        } catch (FileNotFoundException f){

            dataL = "Stock with symbol " + symbol + " not found";
        } catch (UnknownHostException un){

            dataL = "Please check your internet connection";
        }

        catch(Exception e){

            e.printStackTrace();
        }


        return dataL;

    }

    public StockResponse watchStock(String symbol, String name) throws Exception {


        StockResponse stockPersist = new StockResponse(new Stock(), "Stock saved successfully!!");
   // String dataT = "";

        ObjectMapper objectMapper = new ObjectMapper();



        try {
            URL url = new URL("https://api.iextrading.com/1.0/stock/" + symbol + "/quote?filter=symbol,companyName,sector,open,close,high,low,latestPrice,latestTime,delayedPrice,extendedPrice,lastVolume,change,changePercent,peRatio,marketCap");


            stockPersist.setStock(objectMapper.readValue(url, Stock.class));
            stockPersist.getStock().setName(name);



            this.stockRepository.save(stockPersist.getStock());

        }catch (FileNotFoundException fe){

           return new StockResponse("No data found for " + stockPersist.getStock().getSymbol() + " symbol");

        }catch (DataNotFoundException da){

            return new StockResponse("No data found");

        }catch (UnknownHostException un){

            return new StockResponse("Please check your internet connection");

        }catch(Exception e){

            e.printStackTrace();

        }



    return stockPersist;
    }


    public List<Stock> getStocks() {


        return stockRepository.findAll();
    }
}

//TODO junit test cases
//TODO Exception Handling