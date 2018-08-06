package co.app.train.nedj.Repositories;

import co.app.train.nedj.Model.Stock;
import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, String> {
    // String watchStock save(String inputLine);
    //   @Transactional
    // will trigger the query annotated to the method as updating query instead of a selecting one
   // @Modifying
  //  @Query("Update Stock p SET p.symbol = :symbol WHERE p.symbol = :symbol")
    //public int updateQuantity(@Param("productID") int symbol, @Param("name") String name);
}
