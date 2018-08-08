package co.app.train.nedj.Controller;

import co.app.train.nedj.Exceptions.DataNotFoundException;
import co.app.train.nedj.Model.Stock;
import co.app.train.nedj.Model.StockResponse;
import  co.app.train.nedj.Services.StockService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//adds the @Controller and @ResponseBody annotations
@RestController
//map web requests onto specific handler classes and/or handler methods.
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService stockService;



    //====================Get based on symbol==========================
    @RequestMapping(value = "/getStock/{symbol}" , method = RequestMethod.GET)
    @ResponseBody
    public String getStock(@PathVariable String symbol) throws IOException {
        String stock = stockService.getStock(symbol);
        if(stock == null || stock.isEmpty())
        {

        }
        return this.stockService.getStock(symbol);
    }


    //===================Watch stock base on symbol
    @RequestMapping(value = "/watchStock/{symbol}/{name}", method = RequestMethod.POST)
    @ResponseBody
    public StockResponse watchStock(@PathVariable String symbol, @PathVariable String name) throws Exception{


        return this.stockService.watchStock(symbol, name);
    }

    //==================Get all stocks
    @RequestMapping(value = "/getStocks", method = RequestMethod.GET)
    @ResponseBody
    public List<Stock> getStocks() throws  Exception
    {
        List<Stock> listStock = stockService.getStocks();

        if(listStock == null || listStock.isEmpty())
        {
            throw new DataNotFoundException("Stock name do not exist....");
        }
        return listStock;
    }

}

//TODO exception handling
