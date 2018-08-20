package stock.nedj.Repositories;

import stock.nedj.Model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

    List<Stock> findByName(@Param("name") String name);

}