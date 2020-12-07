package ig.api.client.rest.model;

import com.fasterxml.jackson.annotation.*;

public class ActivityMetadata {

    private ActivityMetadataPage paging;

    @JsonProperty("paging")
    public ActivityMetadataPage getPaging() {
        return paging;
    }

    @JsonProperty("paging")
    public void setPaging(ActivityMetadataPage value) {
        this.paging = value;
    }
}
