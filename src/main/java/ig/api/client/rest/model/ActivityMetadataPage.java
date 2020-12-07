package ig.api.client.rest.model;

import com.fasterxml.jackson.annotation.*;

public class ActivityMetadataPage {

    private long size;
    private String next;

    @JsonProperty("size")
    public long getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(long value) {
        this.size = value;
    }

    @JsonProperty("next")
    public String getNext() {
        return next;
    }

    @JsonProperty("next")
    public void setNext(String value) {
        this.next = value;
    }
}
