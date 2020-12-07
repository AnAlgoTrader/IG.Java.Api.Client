package ig.api.client.rest.model;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

public class Transaction {

    private String date;
    private OffsetDateTime dateUTC;
    private OffsetDateTime openDateUTC;
    private String instrumentName;
    private String period;
    private String profitAndLoss;
    private String transactionType;
    private String reference;
    private String openLevel;
    private String closeLevel;
    private String size;
    private String currency;
    private boolean cashTransaction;

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String value) {
        this.date = value;
    }

    @JsonProperty("dateUtc")
    public OffsetDateTime getDateUTC() {
        return dateUTC;
    }

    @JsonProperty("dateUtc")
    public void setDateUTC(OffsetDateTime value) {
        this.dateUTC = value;
    }

    @JsonProperty("openDateUtc")
    public OffsetDateTime getOpenDateUTC() {
        return openDateUTC;
    }

    @JsonProperty("openDateUtc")
    public void setOpenDateUTC(OffsetDateTime value) {
        this.openDateUTC = value;
    }

    @JsonProperty("instrumentName")
    public String getInstrumentName() {
        return instrumentName;
    }

    @JsonProperty("instrumentName")
    public void setInstrumentName(String value) {
        this.instrumentName = value;
    }

    @JsonProperty("period")
    public String getPeriod() {
        return period;
    }

    @JsonProperty("period")
    public void setPeriod(String value) {
        this.period = value;
    }

    @JsonProperty("profitAndLoss")
    public String getProfitAndLoss() {
        return profitAndLoss;
    }

    @JsonProperty("profitAndLoss")
    public void setProfitAndLoss(String value) {
        this.profitAndLoss = value;
    }

    @JsonProperty("transactionType")
    public String getTransactionType() {
        return transactionType;
    }

    @JsonProperty("transactionType")
    public void setTransactionType(String value) {
        this.transactionType = value;
    }

    @JsonProperty("reference")
    public String getReference() {
        return reference;
    }

    @JsonProperty("reference")
    public void setReference(String value) {
        this.reference = value;
    }

    @JsonProperty("openLevel")
    public String getOpenLevel() {
        return openLevel;
    }

    @JsonProperty("openLevel")
    public void setOpenLevel(String value) {
        this.openLevel = value;
    }

    @JsonProperty("closeLevel")
    public String getCloseLevel() {
        return closeLevel;
    }

    @JsonProperty("closeLevel")
    public void setCloseLevel(String value) {
        this.closeLevel = value;
    }

    @JsonProperty("size")
    public String getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(String value) {
        this.size = value;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String value) {
        this.currency = value;
    }

    @JsonProperty("cashTransaction")
    public boolean getCashTransaction() {
        return cashTransaction;
    }

    @JsonProperty("cashTransaction")
    public void setCashTransaction(boolean value) {
        this.cashTransaction = value;
    }
}
