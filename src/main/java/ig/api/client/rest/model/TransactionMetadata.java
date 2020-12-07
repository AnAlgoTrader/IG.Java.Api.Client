package ig.api.client.rest.model;

import com.fasterxml.jackson.annotation.*;

public class TransactionMetadata {

    private long size;
    private TransactionMetadataPage pageData;

    @JsonProperty("size")
    public long getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(long value) {
        this.size = value;
    }

    @JsonProperty("pageData")
    public TransactionMetadataPage getPageData() {
        return pageData;
    }

    @JsonProperty("pageData")
    public void setPageData(TransactionMetadataPage value) {
        this.pageData = value;
    }
}
