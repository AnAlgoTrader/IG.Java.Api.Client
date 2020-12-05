package ig.api.client.rest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestClient {

    private HttpClient client;

    public RestClient() {
        client = HttpClient.newHttpClient();
    }

    public void Authenticate(String username, String password, String apiKey) throws IOException, InterruptedException {

        HashMap values = new HashMap<String, String>() {
            {
                put("identifier", username);
                put("password", password);
            }
        };

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(values);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/post"))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
