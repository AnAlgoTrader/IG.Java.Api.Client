package ig.api.client.rest.helper;

import ig.api.client.rest.response.PositionsResponseItem;

public class PositionsHelper {

    public static double CalculateProfitLoss(PositionsResponseItem item) {

        if (null == item.getPosition().getDirection()) {
            return 0.0;
        } else {
            switch (item.getPosition().getDirection()) {
                case "BUY":
                    return (item.getMarket().getBid() - item.getPosition().getLevel()) * item.getPosition().getSize();
                case "SELL":
                    return (item.getPosition().getLevel() - item.getMarket().getOffer()) * item.getPosition().getSize();
                default:
                    return 0.0;
            }
        }
    }

    public static String CalculateColor(PositionsResponseItem item) {

        return item.getPosition().getProfitLoss() > 0.0 ? "green" : "red";
    }
}
