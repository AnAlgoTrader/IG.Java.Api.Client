package ig.api.client.rest.model;

import com.fasterxml.jackson.annotation.*;

public class TransactionMetadataPage {

    private long pageSize;
    private long pageNumber;
    private long totalPages;

    @JsonProperty("pageSize")
    public long getPageSize() {
        return pageSize;
    }

    @JsonProperty("pageSize")
    public void setPageSize(long value) {
        this.pageSize = value;
    }

    @JsonProperty("pageNumber")
    public long getPageNumber() {
        return pageNumber;
    }

    @JsonProperty("pageNumber")
    public void setPageNumber(long value) {
        this.pageNumber = value;
    }

    @JsonProperty("totalPages")
    public long getTotalPages() {
        return totalPages;
    }

    @JsonProperty("totalPages")
    public void setTotalPages(long value) {
        this.totalPages = value;
    }
}
