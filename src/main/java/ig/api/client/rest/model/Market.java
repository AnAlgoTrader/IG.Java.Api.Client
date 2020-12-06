package ig.api.client.rest.model;

import com.fasterxml.jackson.annotation.*;

public class Market {
    private String instrumentName;
    private String expiry;
    private String epic;
    private String instrumentType;
    private long lotSize;
    private double high;
    private double low;
    private long percentageChange;
    private long netChange;
    private double bid;
    private double offer;
    private String updateTime;
    private String updateTimeUTC;
    private long delayTime;
    private boolean streamingPricesAvailable;
    private String marketStatus;
    private long scalingFactor;

    @JsonProperty("instrumentName")
    public String getInstrumentName() { return instrumentName; }
    @JsonProperty("instrumentName")
    public void setInstrumentName(String value) { this.instrumentName = value; }

    @JsonProperty("expiry")
    public String getExpiry() { return expiry; }
    @JsonProperty("expiry")
    public void setExpiry(String value) { this.expiry = value; }

    @JsonProperty("epic")
    public String getEpic() { return epic; }
    @JsonProperty("epic")
    public void setEpic(String value) { this.epic = value; }

    @JsonProperty("instrumentType")
    public String getInstrumentType() { return instrumentType; }
    @JsonProperty("instrumentType")
    public void setInstrumentType(String value) { this.instrumentType = value; }

    @JsonProperty("lotSize")
    public long getLotSize() { return lotSize; }
    @JsonProperty("lotSize")
    public void setLotSize(long value) { this.lotSize = value; }

    @JsonProperty("high")
    public double getHigh() { return high; }
    @JsonProperty("high")
    public void setHigh(double value) { this.high = value; }

    @JsonProperty("low")
    public double getLow() { return low; }
    @JsonProperty("low")
    public void setLow(double value) { this.low = value; }

    @JsonProperty("percentageChange")
    public long getPercentageChange() { return percentageChange; }
    @JsonProperty("percentageChange")
    public void setPercentageChange(long value) { this.percentageChange = value; }

    @JsonProperty("netChange")
    public long getNetChange() { return netChange; }
    @JsonProperty("netChange")
    public void setNetChange(long value) { this.netChange = value; }

    @JsonProperty("bid")
    public double getBid() { return bid; }
    @JsonProperty("bid")
    public void setBid(double value) { this.bid = value; }

    @JsonProperty("offer")
    public double getOffer() { return offer; }
    @JsonProperty("offer")
    public void setOffer(double value) { this.offer = value; }

    @JsonProperty("updateTime")
    public String getUpdateTime() { return updateTime; }
    @JsonProperty("updateTime")
    public void setUpdateTime(String value) { this.updateTime = value; }

    @JsonProperty("updateTimeUTC")
    public String getUpdateTimeUTC() { return updateTimeUTC; }
    @JsonProperty("updateTimeUTC")
    public void setUpdateTimeUTC(String value) { this.updateTimeUTC = value; }

    @JsonProperty("delayTime")
    public long getDelayTime() { return delayTime; }
    @JsonProperty("delayTime")
    public void setDelayTime(long value) { this.delayTime = value; }

    @JsonProperty("streamingPricesAvailable")
    public boolean getStreamingPricesAvailable() { return streamingPricesAvailable; }
    @JsonProperty("streamingPricesAvailable")
    public void setStreamingPricesAvailable(boolean value) { this.streamingPricesAvailable = value; }

    @JsonProperty("marketStatus")
    public String getMarketStatus() { return marketStatus; }
    @JsonProperty("marketStatus")
    public void setMarketStatus(String value) { this.marketStatus = value; }

    @JsonProperty("scalingFactor")
    public long getScalingFactor() { return scalingFactor; }
    @JsonProperty("scalingFactor")
    public void setScalingFactor(long value) { this.scalingFactor = value; }
}