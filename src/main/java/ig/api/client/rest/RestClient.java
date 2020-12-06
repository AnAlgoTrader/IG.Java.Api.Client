package ig.api.client.rest;

import ig.api.client.rest.request.AuthenticationRequest;
import ig.api.client.rest.response.AuthenticationResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
    private final CloseableHttpClient closeableHttpClient;
    private AuthenticationResponse authenticationResponse;
    private String key;

    public RestClient(String environment) {
        baseUri = String.format("https://%sapi.ig.com", "live".equals(environment) ? "" : "demo-");
        closeableHttpClient = HttpClients.createDefault();
    }

    private boolean ShouldAuthenticate(String authResponsePath) throws IOException {
        Path filePath = Path.of(authResponsePath);
        if (!Files.exists(filePath)) {
            return true;
        } else {
            String fileContent = Files.readString(filePath);
            AuthenticationResponse authResponse = AuthenticationResponse.fromJsonString(fileContent);
            authenticationResponse = authResponse;
            int hours = GetElapsedHours(authResponse.getDate(), new Date(System.currentTimeMillis()));
            return hours > 5;
        }
    }

    private static int GetElapsedHours(Date start, Date end) {
        final int MILLI_TO_HOUR = 1000 * 60 * 60;
        return Math.abs((int) (end.getTime() - start.getTime()) / MILLI_TO_HOUR);
    }
    
    public void GetAccounts() throws IOException{
        String response = Get(baseUri + ACCOUNTS_URI, "1");
        System.out.println(response);        
    }

    public AuthenticationResponse Authenticate(String username, String password, String apiKey, String authResponsePath) throws IOException, InterruptedException {

        key = apiKey;
        
        if (ShouldAuthenticate(authResponsePath)) {

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
                Files.write(Path.of(authResponsePath), AuthenticationResponse.toJsonString(authResponse).getBytes());
            }
        }

        return authenticationResponse;
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
    
    public void Close() throws IOException{
        closeableHttpClient.close();
    }
}
