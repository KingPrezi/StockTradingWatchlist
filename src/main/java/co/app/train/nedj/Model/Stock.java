package co.app.train.nedj.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "stock")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQueries({
       @NamedQuery(name = "Stock.findBySymbol", query = "SELECT s FROM Stock s WHERE s.symbol = :symbol")})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock implements Serializable {
    //universal version identifier for a Serializable class
    private static final long serialVersionUID = 1L;
    //indicating the member field below is the primary key of current entity.


    //lastVolume,change,changePercent,peRatio,marketCap/

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

    @Column(name = "pRatio")
    private String pRatio;

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

    @Column (name = "lastVolume")
    private String lastVolume;

    @Column(name = "changes")
    private String changes;

    @Column(name = "changePercent")
    private String changePercent;

    @Column(name = "markCap")
    private String markCap;

    private String response;

}
