package ig.api.client.rest;

import ig.api.client.rest.request.AuthenticationRequest;
import ig.api.client.rest.response.AuthenticationResponse;
import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {

    private final String baseUri;
    private final String SESSION_URI = "/gateway/deal/session";
    private String key;
    private String token;
    private String clientId;

    public RestClient(String environment) {
        baseUri = String.format("https://%sapi.ig.com", "live".equals(environment) ? "" : "demo-");
    }

    public void Authenticate(String username, String password, String apiKey) throws IOException, InterruptedException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(baseUri + SESSION_URI);
            AuthenticationRequest request = new AuthenticationRequest();
            request.setIdentifier(username);
            request.setPassword(password);
            StringEntity entity = new StringEntity(AuthenticationRequest.toJsonString(request));
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("Version", "3");
            httpPost.setHeader("X-IG-API-KEY", apiKey);
            try (CloseableHttpResponse response = client.execute(httpPost)) {
                String responseString = new BasicResponseHandler().handleResponse(response);
                AuthenticationResponse authenticationResponse = AuthenticationResponse.fromJsonString(responseString);
                key = apiKey;
                token = authenticationResponse.getOauthToken().getAccessToken();
                clientId = authenticationResponse.getClientID();                
            }
        }
    }
}
