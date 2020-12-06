package ig.api.client.rest.model;

import com.fasterxml.jackson.annotation.*;

public class Account {

    private String accountID;
    private String accountName;
    private Object accountAlias;
    private String status;
    private String accountType;
    private boolean preferred;
    private Balance balance;
    private String currency;
    private boolean canTransferFrom;
    private boolean canTransferTo;

    @JsonProperty("accountId")
    public String getAccountID() {
        return accountID;
    }

    @JsonProperty("accountId")
    public void setAccountID(String value) {
        this.accountID = value;
    }

    @JsonProperty("accountName")
    public String getAccountName() {
        return accountName;
    }

    @JsonProperty("accountName")
    public void setAccountName(String value) {
        this.accountName = value;
    }

    @JsonProperty("accountAlias")
    public Object getAccountAlias() {
        return accountAlias;
    }

    @JsonProperty("accountAlias")
    public void setAccountAlias(Object value) {
        this.accountAlias = value;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String value) {
        this.status = value;
    }

    @JsonProperty("accountType")
    public String getAccountType() {
        return accountType;
    }

    @JsonProperty("accountType")
    public void setAccountType(String value) {
        this.accountType = value;
    }

    @JsonProperty("preferred")
    public boolean getPreferred() {
        return preferred;
    }

    @JsonProperty("preferred")
    public void setPreferred(boolean value) {
        this.preferred = value;
    }

    @JsonProperty("balance")
    public Balance getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(Balance value) {
        this.balance = value;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String value) {
        this.currency = value;
    }

    @JsonProperty("canTransferFrom")
    public boolean getCanTransferFrom() {
        return canTransferFrom;
    }

    @JsonProperty("canTransferFrom")
    public void setCanTransferFrom(boolean value) {
        this.canTransferFrom = value;
    }

    @JsonProperty("canTransferTo")
    public boolean getCanTransferTo() {
        return canTransferTo;
    }

    @JsonProperty("canTransferTo")
    public void setCanTransferTo(boolean value) {
        this.canTransferTo = value;
    }
}
