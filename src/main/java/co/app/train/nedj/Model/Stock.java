package co.app.train.nedj.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@NamedQueries({
        @NamedQuery(name = "Stock.findAll", query = "SELECT p FROM Stock p")
        , @NamedQuery(name = "Stock.findBySymbol", query = "SELECT p FROM Stock p WHERE p.symbol = :symbol")})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock implements Serializable {
    //universal version identifier for a Serializable class
    private static final long serialVersionUID = 1L;
    //indicating the member field below is the primary key of current entity.


    //lastVolume,change,changePercent,peRatio,marketCap/

    @Id
    @NotNull
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
    private Integer latestTime;


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







    public Stock() {
    }

   /* public Stock(String symbol, String name, String companyName, String sector, String open, String close, String peRatio, String high, Integer low, Integer latestPrice, Integer latestTime, String delayedPrice, String extendedPrice, String lastVolume, String change, String changePercent, String pRatio, String markCap) {
        this.symbol = symbol;
        this.name = name;
        this.companyName = companyName;
        this.sector = sector;
        this.open = open;
        this.close = close;
        this.peRatio = peRatio;
        this.high = high;
        this.low = low;
        this.latestPrice = latestPrice;
        this.latestTime = latestTime;
        this.delayedPrice = delayedPrice;
        this.extendedPrice = extendedPrice;
        this.lastVolume = lastVolume;
        this.change = change;
        this.changePercent = changePercent;
        this.pRatio = pRatio;
        this.markCap = markCap;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(String peRatio) {
        this.peRatio = peRatio;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public Integer getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(Integer latestPrice) {
        this.latestPrice = latestPrice;
    }

    public Integer getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(Integer latestTime) {
        this.latestTime = latestTime;
    }

    public String getDelayedPrice() {
        return delayedPrice;
    }

    public void setDelayedPrice(String delayedPrice) {
        this.delayedPrice = delayedPrice;
    }

    public String getExtendedPrice() {
        return extendedPrice;
    }

    public void setExtendedPrice(String extendedPrice) {
        this.extendedPrice = extendedPrice;
    }

    public String getLastVolume() {
        return lastVolume;
    }

    public void setLastVolume(String lastVolume) {
        this.lastVolume = lastVolume;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
    }

    public String getpRatio() {
        return pRatio;
    }

    public void setpRatio(String pRatio) {
        this.pRatio = pRatio;
    }

    public String getMarkCap() {
        return markCap;
    }

    public void setMarkCap(String markCap) {
        this.markCap = markCap;
    }*/























}
