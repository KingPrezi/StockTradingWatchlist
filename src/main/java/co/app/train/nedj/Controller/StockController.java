package co.app.train.nedj.Controller;

import co.app.train.nedj.Exceptions.DataNotFoundException;
import co.app.train.nedj.Model.Stock;
import  co.app.train.nedj.Services.StockService;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//adds the @Controller and @ResponseBody annotations
@RestController
//map web requests onto specific handler classes and/or handler methods.
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    //=============================Find All products==========================
   /* @RequestMapping(value = "/findAllStock" , method = RequestMethod.GET)
    //used to bind the HTTP request/response body with a domain object in method parameter or return type
    @ResponseBody
    public Object findAllStock() throws Exception {
        Object stock = stockService.findAllStock();
        try {
            stock = stockService.findAllStock();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(stock == null)
        {
            throw new DataNotFoundException("Stock Not Found...");
        }
        return stock;
    }*/

    //====================Find based on ==========================
    @RequestMapping(value = "/findStockBySymbol{symbol}" , method = RequestMethod.GET)
    @ResponseBody
    public String findStockBySymbol(@PathVariable String symbol) throws IOException {
        String stock = stockService.findStockBySymbol(symbol);
        if(stock == null)
        {
            throw new DataNotFoundException("Stock Do Not exists...");
        }
        return stock;
    }



    @RequestMapping(value = "watchStock/{symbol}/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String watchStock(@PathVariable String symbol, @PathVariable String name) throws Exception{
        String stock = stockService.watchStock(symbol,name);



        return stock;
    }
}

//TODO exception handling
//TODO add user names in watch stock