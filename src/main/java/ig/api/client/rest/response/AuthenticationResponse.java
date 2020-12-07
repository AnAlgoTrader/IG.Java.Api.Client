package ig.api.client.rest.response;

import ig.api.client.rest.model.OauthToken;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import ig.api.client.rest.helper.FormatHelper;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Date;

public class AuthenticationResponse {

    private Date date;
    private String clientID;
    private String accountID;
    private long timezoneOffset;
    private String lightstreamerEndpoint;
    private OauthToken oauthToken;

    @JsonProperty("date")
    public Date getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(Date value) {
        this.date = value;
    }

    @JsonProperty("clientId")
    public String getClientID() {
        return clientID;
    }

    @JsonProperty("clientId")
    public void setClientID(String value) {
        this.clientID = value;
    }

    @JsonProperty("accountId")
    public String getAccountID() {
        return accountID;
    }

    @JsonProperty("accountId")
    public void setAccountID(String value) {
        this.accountID = value;
    }

    @JsonProperty("timezoneOffset")
    public long getTimezoneOffset() {
        return timezoneOffset;
    }

    @JsonProperty("timezoneOffset")
    public void setTimezoneOffset(long value) {
        this.timezoneOffset = value;
    }

    @JsonProperty("lightstreamerEndpoint")
    public String getLightstreamerEndpoint() {
        return lightstreamerEndpoint;
    }

    @JsonProperty("lightstreamerEndpoint")
    public void setLightstreamerEndpoint(String value) {
        this.lightstreamerEndpoint = value;
    }

    @JsonProperty("oauthToken")
    public OauthToken getOauthToken() {
        return oauthToken;
    }

    @JsonProperty("oauthToken")
    public void setOauthToken(OauthToken value) {
        this.oauthToken = value;
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
        reader = mapper.readerFor(AuthenticationResponse.class);
        writer = mapper.writerFor(AuthenticationResponse.class);
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

    public static AuthenticationResponse fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(AuthenticationResponse obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }
}
