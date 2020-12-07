package ig.api.client.rest.request;

import com.fasterxml.jackson.annotation.*;
import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import ig.api.client.rest.helper.FormatHelper;
import java.time.OffsetDateTime;

public class CloseMarketPositionRequest {

    private String dealID;
    private String direction;
    private String orderType;
    private double size;

    @JsonProperty("dealId")
    public String getDealID() {
        return dealID;
    }

    @JsonProperty("dealId")
    public void setDealID(String value) {
        this.dealID = value;
    }

    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    @JsonProperty("direction")
    public void setDirection(String value) {
        this.direction = value;
    }

    @JsonProperty("orderType")
    public String getOrderType() {
        return orderType;
    }

    @JsonProperty("orderType")
    public void setOrderType(String value) {
        this.orderType = value;
    }

    @JsonProperty("size")
    public double getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(double value) {
        this.size = value;
    }

    public static CloseMarketPositionRequest fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(CloseMarketPositionRequest obj) throws JsonProcessingException {
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
        reader = mapper.readerFor(CloseMarketPositionRequest.class);
        writer = mapper.writerFor(CloseMarketPositionRequest.class);
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
