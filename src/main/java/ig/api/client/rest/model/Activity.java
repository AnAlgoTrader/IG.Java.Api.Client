package ig.api.client.rest.model;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;

public class Activity {
    private OffsetDateTime date;
    private String epic;
    private String period;
    private String dealID;
    private String channel;
    private String type;
    private String status;
    private String description;
    private String details;

    @JsonProperty("date")
    public OffsetDateTime getDate() { return date; }
    @JsonProperty("date")
    public void setDate(OffsetDateTime value) { this.date = value; }

    @JsonProperty("epic")
    public String getEpic() { return epic; }
    @JsonProperty("epic")
    public void setEpic(String value) { this.epic = value; }

    @JsonProperty("period")
    public String getPeriod() { return period; }
    @JsonProperty("period")
    public void setPeriod(String value) { this.period = value; }

    @JsonProperty("dealId")
    public String getDealID() { return dealID; }
    @JsonProperty("dealId")
    public void setDealID(String value) { this.dealID = value; }

    @JsonProperty("channel")
    public String getChannel() { return channel; }
    @JsonProperty("channel")
    public void setChannel(String value) { this.channel = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("status")
    public String getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(String value) { this.status = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("details")
    public String getDetails() { return details; }
    @JsonProperty("details")
    public void setDetails(String value) { this.details = value; }
}