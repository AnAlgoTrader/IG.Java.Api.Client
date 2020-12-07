package ig.api.client.rest.request;

import com.fasterxml.jackson.annotation.*;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import ig.api.client.rest.helper.FormatHelper;
import java.time.OffsetDateTime;

public class OpenPositionRequest {

    private String epic;
    private String expiry;
    private String direction;
    private double size;
    private String orderType;
    private boolean guaranteedStop;
    private boolean trailingStop;
    private boolean forceOpen;
    private String currencyCode;

    @JsonProperty("epic")
    public String getEpic() {
        return epic;
    }

    @JsonProperty("epic")
    public void setEpic(String value) {
        this.epic = value;
    }

    @JsonProperty("expiry")
    public String getExpiry() {
        return expiry;
    }

    @JsonProperty("expiry")
    public void setExpiry(String value) {
        this.expiry = value;
    }

    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    @JsonProperty("direction")
    public void setDirection(String value) {
        this.direction = value;
    }

    @JsonProperty("size")
    public double getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(double value) {
        this.size = value;
    }

    @JsonProperty("orderType")
    public String getOrderType() {
        return orderType;
    }

    @JsonProperty("orderType")
    public void setOrderType(String value) {
        this.orderType = value;
    }

    @JsonProperty("guaranteedStop")
    public boolean getGuaranteedStop() {
        return guaranteedStop;
    }

    @JsonProperty("guaranteedStop")
    public void setGuaranteedStop(boolean value) {
        this.guaranteedStop = value;
    }

    @JsonProperty("trailingStop")
    public boolean getTrailingStop() {
        return trailingStop;
    }

    @JsonProperty("trailingStop")
    public void setTrailingStop(boolean value) {
        this.trailingStop = value;
    }

    @JsonProperty("forceOpen")
    public boolean getForceOpen() {
        return forceOpen;
    }

    @JsonProperty("forceOpen")
    public void setForceOpen(boolean value) {
        this.forceOpen = value;
    }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currencyCode")
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    public static OpenPositionRequest fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(OpenPositionRequest obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return FormatHelper.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(OpenPositionRequest.class);
        writer = mapper.writerFor(OpenPositionRequest.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) {
            instantiateMapper();
        }
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) {
            instantiateMapper();
        }
        return writer;
    }
}
