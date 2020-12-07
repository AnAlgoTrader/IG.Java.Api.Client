package ig.api.client.rest.model;

import com.fasterxml.jackson.annotation.*;

public class Position {
    private double contractSize;
    private String createdDate;
    private String createdDateUTC;
    private String dealID;
    private String dealReference;
    private double size;
    private String direction;
    private double limitLevel;
    private double level;
    private String currency;
    private boolean controlledRisk;
    private double stopLevel;
    private double trailingStep;
    private double trailingStopDistance;
    private double limitedRiskPremium;
    private double profitLoss;
    private String color;
    private double spread;

    @JsonProperty("contractSize")
    public double getContractSize() { return contractSize; }
    @JsonProperty("contractSize")
    public void setContractSize(double value) { this.contractSize = value; }

    @JsonProperty("createdDate")
    public String getCreatedDate() { return createdDate; }
    @JsonProperty("createdDate")
    public void setCreatedDate(String value) { this.createdDate = value; }

    @JsonProperty("createdDateUTC")
    public String getCreatedDateUTC() { return createdDateUTC; }
    @JsonProperty("createdDateUTC")
    public void setCreatedDateUTC(String value) { this.createdDateUTC = value; }

    @JsonProperty("dealId")
    public String getDealID() { return dealID; }
    @JsonProperty("dealId")
    public void setDealID(String value) { this.dealID = value; }

    @JsonProperty("dealReference")
    public String getDealReference() { return dealReference; }
    @JsonProperty("dealReference")
    public void setDealReference(String value) { this.dealReference = value; }

    @JsonProperty("size")
    public double getSize() { return size; }
    @JsonProperty("size")
    public void setSize(double value) { this.size = value; }

    @JsonProperty("direction")
    public String getDirection() { return direction; }
    @JsonProperty("direction")
    public void setDirection(String value) { this.direction = value; }

    @JsonProperty("limitLevel")
    public double getLimitLevel() { return limitLevel; }
    @JsonProperty("limitLevel")
    public void setLimitLevel(double value) { this.limitLevel = value; }

    @JsonProperty("level")
    public double getLevel() { return level; }
    @JsonProperty("level")
    public void setLevel(double value) { this.level = value; }

    @JsonProperty("currency")
    public String getCurrency() { return currency; }
    @JsonProperty("currency")
    public void setCurrency(String value) { this.currency = value; }

    @JsonProperty("controlledRisk")
    public boolean getControlledRisk() { return controlledRisk; }
    @JsonProperty("controlledRisk")
    public void setControlledRisk(boolean value) { this.controlledRisk = value; }

    @JsonProperty("stopLevel")
    public double getStopLevel() { return stopLevel; }
    @JsonProperty("stopLevel")
    public void setStopLevel(double value) { this.stopLevel = value; }

    @JsonProperty("trailingStep")
    public double getTrailingStep() { return trailingStep; }
    @JsonProperty("trailingStep")
    public void setTrailingStep(double value) { this.trailingStep = value; }

    @JsonProperty("trailingStopDistance")
    public double getTrailingStopDistance() { return trailingStopDistance; }
    @JsonProperty("trailingStopDistance")
    public void setTrailingStopDistance(double value) { this.trailingStopDistance = value; }

    @JsonProperty("limitedRiskPremium")
    public double getLimitedRiskPremium() { return limitedRiskPremium; }
    @JsonProperty("limitedRiskPremium")
    public void setLimitedRiskPremium(double value) { this.limitedRiskPremium = value; }
    
    public double getProfitLoss() { return profitLoss; }
    public void setProfitLoss(double value) { this.profitLoss = value; }    
    
    public String getColor() { return color; }
    public void setColor(String value) { this.color = value; }    
    
    public double getSpread() { return spread; }
    public void setSpread(double value) { this.spread = value; }  
}