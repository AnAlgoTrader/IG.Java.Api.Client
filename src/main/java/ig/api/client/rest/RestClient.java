package ig.api.client.rest;

import ig.api.client.rest.helper.PositionsHelper;
import ig.api.client.rest.model.Position;
import ig.api.client.rest.request.AuthenticationRequest;
import ig.api.client.rest.response.AccountsResponse;
import ig.api.client.rest.response.AuthenticationResponse;
import ig.api.client.rest.response.PositionsResponse;
import ig.api.client.rest.response.PositionsResponseItem;
import java.io.IOException;
import java.util.Date;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class RestClient {

    private final String baseUri;
    private final String SESSION_URI = "/gateway/deal/session";
    private final String ACCOUNTS_URI = "/gateway/deal/accounts";
    private final String TRANSACTIONS_URI = "/gateway/deal/history/transactions";
    private final String ACTIVITIES_URI = "/gateway/deal/history/activity";
    private final String PRICES_URI = "/gateway/deal/prices";
    private final String POSITIONS_OTC_URI = "/gateway/deal/positions/otc";
    private final String POSITIONS_URI = "/gateway/deal/positions";
    private final String WORKING_ORDERS_URI = "/gateway/deal/workingorders/otc";
    private final String TRADE_CONFIRM_URI = "/gateway/deal/confirms";

    private final CloseableHttpClient closeableHttpClient;
    private AuthenticationResponse authenticationResponse;
    private String key;

    public RestClient(String environment) {
        baseUri = String.format("https://%sapi.ig.com", "live".equals(environment) ? "" : "demo-");
        closeableHttpClient = HttpClients.createDefault();
    }

    public PositionsResponse GetPositions() throws IOException {
        String strResponse = Get(baseUri + POSITIONS_URI, "2");
        PositionsResponse positionsResponse = PositionsResponse.fromJsonString(strResponse);
        for(PositionsResponseItem positionItem : positionsResponse.getPositions()){
            positionItem.getPosition().setProfitLoss(PositionsHelper.CalculateProfitLoss(positionItem));
            positionItem.getPosition().setColor(PositionsHelper.CalculateColor(positionItem));
        }
        return positionsResponse;
    }

    public AccountsResponse GetAccounts() throws IOException {
        String response = Get(baseUri + ACCOUNTS_URI, "1");
        return AccountsResponse.fromJsonString(response);
    }

    public void Authenticate(String username, String password, String apiKey, String authResponsePath) throws IOException, InterruptedException {

        key = apiKey;

        HttpPost httpPost = new HttpPost(baseUri + SESSION_URI);
        AuthenticationRequest request = new AuthenticationRequest();
        request.setIdentifier(username);
        request.setPassword(password);
        StringEntity entity = new StringEntity(AuthenticationRequest.toJsonString(request));
        httpPost.setEntity(entity);
        httpPost.setHeader(HttpHeaders.ACCEPT, "application/json");
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpPost.setHeader("Version", "3");
        httpPost.setHeader("X-IG-API-KEY", apiKey);
        try (CloseableHttpResponse response = closeableHttpClient.execute(httpPost)) {
            String responseString = new BasicResponseHandler().handleResponse(response);
            AuthenticationResponse authResponse = AuthenticationResponse.fromJsonString(responseString);
            authResponse.setDate(new Date(System.currentTimeMillis()));
            authenticationResponse = authResponse;
        }
    }

    public String Get(String url, String version) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader(HttpHeaders.ACCEPT, "application/json");
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpGet.setHeader("VERSION", version);
        httpGet.setHeader("X-IG-API-KEY", key);
        httpGet.setHeader("IG-ACCOUNT-ID", authenticationResponse.getAccountID());
        httpGet.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + authenticationResponse.getOauthToken().getAccessToken());
        try (CloseableHttpResponse response = closeableHttpClient.execute(httpGet)) {
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        }
    }

    public void Close() throws IOException {
        closeableHttpClient.close();
    }
}
