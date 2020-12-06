package ig.api.client.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OauthToken {
    private String accessToken;
    private String refreshToken;
    private String scope;
    private String tokenType;
    private String expiresIn;

    @JsonProperty("access_token")
    public String getAccessToken() { return accessToken; }
    @JsonProperty("access_token")
    public void setAccessToken(String value) { this.accessToken = value; }

    @JsonProperty("refresh_token")
    public String getRefreshToken() { return refreshToken; }
    @JsonProperty("refresh_token")
    public void setRefreshToken(String value) { this.refreshToken = value; }

    @JsonProperty("scope")
    public String getScope() { return scope; }
    @JsonProperty("scope")
    public void setScope(String value) { this.scope = value; }

    @JsonProperty("token_type")
    public String getTokenType() { return tokenType; }
    @JsonProperty("token_type")
    public void setTokenType(String value) { this.tokenType = value; }

    @JsonProperty("expires_in")
    public String getExpiresIn() { return expiresIn; }
    @JsonProperty("expires_in")
    public void setExpiresIn(String value) { this.expiresIn = value; }
}
