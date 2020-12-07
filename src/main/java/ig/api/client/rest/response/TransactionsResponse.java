package ig.api.client.rest.response;

import com.fasterxml.jackson.annotation.*;
import ig.api.client.rest.model.Transaction;
import ig.api.client.rest.model.TransactionMetadata;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import ig.api.client.rest.helper.FormatHelper;
import java.time.OffsetDateTime;


public class TransactionsResponse {

    private Transaction[] transactions;
    private TransactionMetadata metadata;

    @JsonProperty("transactions")
    public Transaction[] getTransactions() {
        return transactions;
    }

    @JsonProperty("transactions")
    public void setTransactions(Transaction[] value) {
        this.transactions = value;
    }

    @JsonProperty("metadata")
    public TransactionMetadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(TransactionMetadata value) {
        this.metadata = value;
    }
    
      public static TransactionsResponse fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(TransactionsResponse obj) throws JsonProcessingException {
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
        reader = mapper.readerFor(TransactionsResponse.class);
        writer = mapper.writerFor(TransactionsResponse.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}
