package stock.nedj.Controller;

import stock.nedj.Model.Response;
import stock.nedj.Model.StockResponse;
import stock.nedj.Services.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    //====================Get Stock based on symbol==========================
    //@RequestMapping(value = "/getStock/{symbol}/{name}" , method = RequestMethod.GET)
    @GetMapping(path = "/getStock/{symbol}/{name}") // Compliant
    public StockResponse getStock(@PathVariable String symbol,@PathVariable String name){

        return this.stockService.getStock(symbol,name);

    }

    //===================Watch stock base on symbol and post to database with username
    //@RequestMapping(value = "/watchStock/{symbol}/{name}", method = RequestMethod.POST)
    @PostMapping(path = "/watchStock/{symbol}/{name}") // Compliant
    public StockResponse watchStock(@PathVariable String symbol, @PathVariable String name){

        return this.stockService.watchStock(symbol, name);

    }

    //==================Get all stocks
    //@RequestMapping(value = "/getStocks/{name}", method = RequestMethod.GET)

    @GetMapping(path = "/getStocks/{name}") // Compliant
    public Response getStocks(@PathVariable String name){

            return stockService.getStocks(name);

    }

}
