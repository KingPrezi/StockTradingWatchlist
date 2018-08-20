package stock.nedj.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "stock")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stockID;
    @Column(name = "symbol")
    private String symbol;

    @Column(name = "name")
    private String name;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "sector")
    private String sector;

    @Column(name = "open")
    private String open;

    @Column(name = "close")
    private String close;

    @Column(name = "peRatio")
    private String peRatio;

    @Column(name ="high")
    private String high;

    @Column(name = "low")
    private Integer low;

    @Column(name = "latestPrice")
    private Integer latestPrice;

    @Column(name = "latestTime")
    private String latestTime;

    @Column(name = "delayedPrice")
    private String delayedPrice;

    @Column(name = "extendedPrice")
    private String extendedPrice;

    @Column(name = "changePercent")
    private String changePercent;

}