package ig.api.client.rest.model;

import com.fasterxml.jackson.annotation.*;

public class Balance {

    private double balance;
    private double deposit;
    private double profitLoss;
    private double available;

    @JsonProperty("balance")
    public double getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(double value) {
        this.balance = value;
    }

    @JsonProperty("deposit")
    public double getDeposit() {
        return deposit;
    }

    @JsonProperty("deposit")
    public void setDeposit(double value) {
        this.deposit = value;
    }

    @JsonProperty("profitLoss")
    public double getProfitLoss() {
        return profitLoss;
    }

    @JsonProperty("profitLoss")
    public void setProfitLoss(double value) {
        this.profitLoss = value;
    }

    @JsonProperty("available")
    public double getAvailable() {
        return available;
    }

    @JsonProperty("available")
    public void setAvailable(double value) {
        this.available = value;
    }
}
