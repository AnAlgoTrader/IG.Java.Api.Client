package ig.api.client.rest.model;

import com.fasterxml.jackson.annotation.*;

public class Metadata {

    private Paging paging;

    @JsonProperty("paging")
    public Paging getPaging() {
        return paging;
    }

    @JsonProperty("paging")
    public void setPaging(Paging value) {
        this.paging = value;
    }
}
