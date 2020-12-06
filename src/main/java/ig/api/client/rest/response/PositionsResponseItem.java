package ig.api.client.rest.response;

import com.fasterxml.jackson.annotation.*;
import ig.api.client.rest.model.Market;
import ig.api.client.rest.model.Position;

public class PositionsResponseItem {

    private Position position;
    private Market market;

    @JsonProperty("position")
    public Position getPosition() {
        return position;
    }

    @JsonProperty("position")
    public void setPosition(Position value) {
        this.position = value;
    }

    @JsonProperty("market")
    public Market getMarket() {
        return market;
    }

    @JsonProperty("market")
    public void setMarket(Market value) {
        this.market = value;
    }
}
