package stock.nedj.Controller;

import com.sun.org.apache.xerces.internal.xs.StringList;
import stock.nedj.Exceptions.DataNotFoundException;
import stock.nedj.Model.Stock;
import stock.nedj.Model.StockResponse;
import stock.nedj.Services.StockService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    //====================Get Stock based on symbol==========================
    @RequestMapping(value = "/getStock/{symbol}/{name}" , method = RequestMethod.GET)
    public StockResponse getStock(@PathVariable String symbol,@PathVariable String name){

        return this.stockService.getStock(symbol,name);

    }

    //===================Watch stock base on symbol and post to database with username
    @RequestMapping(value = "/watchStock/{symbol}/{name}", method = RequestMethod.POST)
    public StockResponse watchStock(@PathVariable String symbol, @PathVariable String name){

        return this.stockService.watchStock(symbol, name);

    }

    //==================Get all stocks
    @RequestMapping(value = "/getStocks/{name}", method = RequestMethod.GET)
    public List<Stock> getStocks(@PathVariable String name) throws Exception {


            return stockService.getStocks(name);


    }

}

//TODO exception handling
